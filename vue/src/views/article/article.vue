<template>
  <div class="app-container">
    <h4 style="text-align: center">文章列表</h4>
    <el-table :data="list" v-loading.body="listLoading" element-loading-text="拼命加载中" border fit
              highlight-current-row size="mini">
      <el-table-column align="center" label="序号" width="80">
        <template slot-scope="scope">
          <span v-text="getIndex(scope.$index)"> </span>
        </template>
      </el-table-column>
      <el-table-column align="center" prop="author" label="作者" sortable style="width: 60px;"></el-table-column>
      <el-table-column align="center" prop="title" label="标题" sortable style="width: 60px;">
        <template slot-scope="scope">
          <a class="aa" @click="goArticle(scope.$index)">{{scope.row.title}}</a>
        </template>
      </el-table-column>
      <el-table-column align="center" prop="comments.length" label="评论数量" sortable style="width: 60px;">
      </el-table-column>
      <!--<el-table-column align="center" prop="content" label="文章" style="width: 60px;"></el-table-column>-->
      <el-table-column align="center" label="创建时间" sortable width="170">
        <template slot-scope="scope">
          <span>{{scope.row.createTime}}</span>
        </template>
      </el-table-column>
      <el-table-column align="center" label="更新时间" sortable width="170">
        <template slot-scope="scope">
          <span>{{scope.row.updateTime}}</span>
        </template>
      </el-table-column>
      <el-table-column align="center" label="管理" width="200" v-if="hasPerm('article:update')">
        <template slot-scope="scope">
          <el-button type="primary" icon="edit" @click="showUpdate(scope.$index)" size="mini">修改</el-button>
          <el-button type="danger" icon="delete" @click="deleteArticle(scope.$index)" size="mini" v-if="hasPerm('article:delete')">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      class="pagination"
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      background
      :current-page="listQuery.pageNum"
      :page-size="listQuery.pageRow"
      :total="totalCount"
      :page-sizes="[10, 20, 50, 100]"
      layout="total, sizes, prev, pager, next, jumper">
    </el-pagination>
    <el-dialog :title="textMap[dialogStatus]" :visible.sync="dialogFormVisible">
      <el-form class="small-space" :model="tempArticle" label-position="left" label-width="80px"
               style='width: 300px; margin-left:50px;'>
        <el-form-item label="文章">
          <el-input type="text" v-model="tempArticle.content">
          </el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button v-if="dialogStatus=='create'" type="success" @click="createArticle">创 建</el-button>
        <el-button type="primary" v-else @click="updateArticle">修 改</el-button>
      </div>
    </el-dialog>

    <div class="filter-container">
      <el-button type="primary" icon="el-icon-plus" @click="showCreate" v-if="hasPerm('article:add')">添加</el-button>
    </div>
  </div>
</template>
<script>
export default {
  data () {
    return {
      totalCount: 0, // 分页组件--数据总条数
      list: [], // 表格的数据
      listLoading: false, // 数据加载等待动画
      listQuery: {
        pageNum: 1, // 页码
        pageRow: 50, // 每页条数
        name: ''
      },
      dialogStatus: 'create',
      dialogFormVisible: false,
      textMap: {
        update: '编辑',
        create: '创建文章'
      },
      tempArticle: {
        id: '',
        content: ''
      }
    }
  },
  created () {
    this.getList()
  },
  methods: {
    getList () {
      // 查询列表
      if (!this.hasPerm('article:list')) {
        return
      }
      this.listLoading = true
      this.api({
        url: '/article/listArticle',
        method: 'get',
        params: this.listQuery
      }).then(data => {
        this.listLoading = false
        this.list = data.list
        this.totalCount = data.totalCount
      })
    },
    handleSizeChange (val) {
      // 改变每页数量
      this.listQuery.pageRow = val
      this.handleFilter()
    },
    handleFilter () {
      this.getList()
    },
    handleCurrentChange (val) {
      // 改变页码
      this.listQuery.pageNum = val
      this.getList()
    },
    getIndex ($index) {
      // 表格序号
      return (this.listQuery.pageNum - 1) * this.listQuery.pageRow + $index + 1
    },
    showCreate () {
      // //显示新增对话框
      // this.tempArticle.content = "";
      // this.dialogStatus = "create"
      // this.dialogFormVisible = true

      this.$router.push({ path: `/article/editor` })
    },
    showUpdate ($index) {
      // 显示修改对话框
      this.tempArticle.id = this.list[$index].id
      this.tempArticle.content = this.list[$index].content
      this.dialogStatus = 'update'
      this.dialogFormVisible = true
    },
    createArticle () {
      // 保存新文章
      this.api({
        url: '/article/addArticle',
        method: 'post',
        data: this.tempArticle
      }).then(() => {
        this.getList()
        this.dialogFormVisible = false
      })
    },
    updateArticle () {
      // 修改文章
      this.api({
        url: '/article/updateArticle',
        method: 'post',
        data: this.tempArticle
      }).then(() => {
        this.getList()
        this.dialogFormVisible = false
      })
    },
    deleteArticle ($index) {
      this.tempArticle.id = this.list[$index].id
      this.tempArticle.content = this.list[$index].content

      // 删除文章
      this.api({
        url: '/article/deleteArticle',
        method: 'post',
        data: this.tempArticle
      }).then(() => {
        this.getList()
      })
    },
    goArticle ($index) {
      var id = this.list[$index].id
      this.$router.push({ path: `/article/show/${id}` })
    }
  }
}
</script>

<style lang="scss" scoped>

 a {color:#FF0000; text-decoration: underline} /* 未访问的链接 */
 a:visited {color:#00FF00;} /* 已访问的链接 */
 a:hover {color:#FF00FF;} /* 鼠标划过链接 */
 a:active {color:#0000FF;} /* 已选中的链接 */

 .filter-container {
  padding: 10px;
 }
</style>
