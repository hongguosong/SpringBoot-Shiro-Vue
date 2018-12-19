<template>
  <div class="app-container">
    <div class="filter-container">
      <el-form>
        <el-form-item>
          <el-button type="primary" icon="el-icon-plus" @click="showCreate" v-if="hasPerm('cart:add')">添加</el-button>
        </el-form-item>
      </el-form>
    </div>
    <el-table :data="list" v-loading.body="listLoading" element-loading-text="拼命加载中" border fit highlight-current-row>
      <el-table-column align="center" label="序号" width="80">
        <template slot-scope="scope">
          <span v-text="getIndex(scope.$index)"></span>
        </template>
      </el-table-column>
      <el-table-column align="center" prop="name" label="名称"></el-table-column>
      <el-table-column align="center" label="数量">
        <template slot-scope="scope">
          <span>{{scope.row.num}}</span>
        </template>
      </el-table-column>
      <el-table-column align="center" label="管理" width="200">
        <template slot-scope="scope">
          <el-button type="primary" icon="el-icon-edit" @click="showUpdate(scope.$index)" v-if="hasPerm('cart:update')" size="mini">修改</el-button>
          <el-button type="danger" icon="el-icon-delete" @click="deleteCart(scope.$index)" v-if="hasPerm('cart:delete')" size="mini">删除</el-button>
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
    <el-dialog :visible.sync="dialogFormVisible">
      <div slot="title">{{textMap[dialogStatus]}}</div>
      <el-form :model="tempCart" label-position="top" label-width="80px" style="width: 500px;margin: auto;">
        <el-form-item label="名称">
          <el-input type="text" v-model="tempCart.name"></el-input>
        </el-form-item>
        <el-form-item label="数量">
          <el-input type="text" v-model="tempCart.num"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取消</el-button>
        <el-button v-if="dialogStatus==='create'" type="success" @click="createCart">创建</el-button>
        <el-button type="primary" v-else @click="updateCart">修改</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name: "cart",
  data() {
    return {
      totalCount: 0,
      list: [],
      listLoading: false,
      listQuery: {
        pageNum: 1,
        pageRow: 50,
        name: ''
      },
      dialogStatus: 'create',
      dialogFormVisible: false,
      textMap: {
        update: '编辑',
        create: '创建'
      },
      tempCart: {
        id: '',
        name: '',
        num: ''
      }
    }
  },
  created () {
    this.getList()
  },
  methods: {
    getList: function () {
      if(!this.hasPerm('cart:list')){
        return
      }
      this.listLoading = true
      this.api({
        url: '/cart/listCart',
        method: 'get',
        params: this.listQuery
      }).then(data => {
        this.listLoading = false
        this.list = data.list
        this.totalCount = data.totalCount
      })
    },
    showCreate: function () {
      this.tempCart.id = ''
      this.tempCart.name = ''
      this.tempCart.num = ''
      this.dialogStatus = 'create'
      this.dialogFormVisible = true
    },
    getIndex: function ($index) {
      return (this.listQuery.pageNum - 1) * this.listQuery.pageRow + $index + 1
    },
    showUpdate: function ($index) {
      this.tempCart.id = this.list[$index].id
      this.tempCart.name = this.list[$index].name
      this.tempCart.num = this.list[$index].num
      this.dialogStatus = 'update'
      this.dialogFormVisible = true
    },
    deleteCart: function ($index) {
      this.tempCart.id = this.list[$index].id
      this.tempCart.name = this.list[$index].name
      this.tempCart.num = this.list[$index].num
      this.api({
        url: '/cart/deleteCart',
        method: 'post',
        data: this.tempCart
      }).then(() => {
        this.getList()
      })
    },
    handleSizeChange: function (val) {
      this.listQuery.pageRow = val
      this.listQuery.pageNum = 1
      this.getList()
    },
    handleCurrentChange: function (val) {
      this.listQuery.pageNum = val
      this.getList()
    },
    createCart: function () {
      this.api({
        url: '/cart/addCart',
        method: 'post',
        data: this.tempCart
      }).then(() => {
        this.getList()
        this.dialogFormVisible = false
      })
    },
    updateCart: function () {
      this.api({
        url: '/cart/updateCart',
        method: 'post',
        data: this.tempCart
      }).then(() => {
        this.getList()
        this.dialogFormVisible = false
      })
    }
  }
}
</script>

<style>
  .el-dialog__header {
    padding: 20px 20px 10px;
    background-color: lightskyblue;
  }
</style>
