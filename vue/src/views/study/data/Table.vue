<template>
  <div id="table">
    <el-table :data="tableData" style="width: 100%" :row-class-name="rableRowClassName" height="300"
      show-summary sum-text="年后" border
      v-loading="loading"
      element-loading-text="拼命加载中"
      element-loading-spinner="el-icon-loading"
      element-loading-background="rgba(0,0,0,0.8)">
      <el-table-column type="selection" width="100"></el-table-column>
      <el-table-column prop="date" label="日期" width="180"></el-table-column>
      <el-table-column prop="name" label="姓名" width="180"></el-table-column>
      <el-table-column prop="address" label="地址"></el-table-column>
    </el-table>
    <br/>
    <div class="filter-container">
      <el-form>
        <el-form-item>
          <el-button type="primary" icon="el-icon-download" @click="exportToExcel">导出</el-button>
        </el-form-item>
      </el-form>
    </div>
    <el-table :data="tableData" stripe border style="width: 100%" max-height="300" :default-sort = "{prop: 'date', order: 'descending'}">
      <el-table-column type="index" label="#" width="50"></el-table-column>
      <el-table-column label="日期" sortable width="180">
        <template slot-scope="scope">
          <i class="el-icon-time"></i>
          <span style="margin-left: 10px">{{ scope.row.date }}</span>
        </template>
      </el-table-column>
      <el-table-column label="配送信息">
        <el-table-column prop="name" label="姓名" sortable width="180"></el-table-column>
        <el-table-column prop="address" label="地址"  width="180"></el-table-column>
      </el-table-column>
      <el-table-column fixed="right" label="操作" width="100">
        <template slot-scope="scope">
          <el-button @click="handleEdit(scope.$index,scope.row)" type="text" size="small">查看</el-button>
          <el-button type="text" size="small">编辑</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import exportToExcel from '@/utils/exportToExcel'
export default {
  data () {
    return {
      tableData: [
        { date: '107-01-09', name: '王小虎', address: '北大街' },
        { date: '107-02-09', name: '王小虎', address: '北大街' },
        { date: '107-03-09', name: '王小虎', address: '北大街' },
        { date: '107-04-09', name: '王小虎', address: '北大街' },
        { date: '107-05-09', name: '王小虎', address: '北大街' },
        { date: '107-07-09', name: '王小虎', address: '北大街' },
        { date: '107-09-09', name: '王小虎', address: '北大街' }
      ],
      loading: true
    }
  },
  methods: {
    rableRowClassName ({ row, rowIndex }) {
      if (rowIndex === 1) {
        return 'warning-row'
      } else if (rowIndex === 3) {
        return 'success-row'
      }
    },
    handleEdit (index, row) {
      this.tableData[index].name = 'dada'
    },
    exportToExcel: function () {
      var _that = this
      var obj = {}
      // obj.title = '地址'
      obj.data = this.tableData
      for (let k = 0; k < obj.data.length; k++) {
        obj.data[k].id = k + 1
      }
      // obj.header = ['id', 'name', 'num']
      obj.columns = [
        { header: '序号', rowSpan: 2, field: 'id' },
        { header: '日期', rowSpan: 2, field: 'date' },
        { header: '配送信息',
          colSpan: 2,
          columns:
          [
            { header: '姓名', field: 'name' },
            { header: '地址', field: 'address' }
          ]
        }
      ]
      this.api({
        url: '/miniui/exportGrid',
        method: 'post',
        data: obj,
        responseType: 'blob'
      }).then((res) => {
        // console.log(res)
        // let blob = new Blob([res], { type: 'application/vnd.ms-excel' })
        // let objectUrl = URL.createObjectURL(blob)
        // window.location.href = objectUrl

        // 此处有个坑。这里用content保存文件流，最初是content=res，但下载的test.xls里的内容如下图1，
        // 检查了下才发现，后端对文件流做了一层封装，所以将content指向res.data即可
        // 另外，流的转储属于浅拷贝，所以此处的content转储仅仅是便于理解，并没有实际作用=_=
        const content = res
        const blob = new Blob([content])// 构造一个blob对象来处理数据
        var now = new Date()
        const fileName = 'address ' + _that.moment(now, 'YYYY_MM_DD HH_mm_ss') + '.xls'
        exportToExcel(blob, fileName)
      }).catch((err) => {
        console.log(err)
      })
    }
  }
}
</script>

<style>
/*body {*/
  /*margin: 0*/
/*}*/

.el-table .warning-row {
  background: oldlace;
}
.el-table .success-row {
  background: #f0f9eb;
}
#table {
  width: 600px;
}
#table .el-table {
  /*border: 1px solid #dddddd;
  padding: 0px;*/
}
</style>
