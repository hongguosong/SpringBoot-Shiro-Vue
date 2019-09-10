<template>
  <div id="alarmVue" style="overflow: auto">
    <el-row>
      <el-col :span="12">
        <div style="font-size: 20px;font-weight: 900;">历史报警</div>
      </el-col>
      <el-col :span="12">
        <span style="float: right;">
          <el-input v-model="searchText" placeholder="请输入报警名称进行搜索" size="mini" style="width:200px;"></el-input>
          <el-button icon="el-icon-search" size="mini" type="primary"></el-button>
          <!--<el-button type="text" style="text-decoration: underline">高级搜索</el-button>-->
        </span>
      </el-col>
    </el-row>
    <el-card class="box-card" :body-style="cardBody" style="margin-top: 5px;">
      <div slot="header">
        <el-row>
          <el-col :span="12">
            <div>
              <div class="timeItem" :class="{active: isActive === 0}" @click="timeItemChange(0)">当天</div>
              <div class="timeItem" :class="{active: isActive === 1}" @click="timeItemChange(1)">本周</div>
              <div class="timeItem" :class="{active: isActive === 2}" @click="timeItemChange(2)">本月</div>
              <div class="timeItem" :class="{active: isActive === 3}" @click="timeItemChange(3)">本年</div>
            </div>
          </el-col>
          <el-col :span="12">
            <span style="float:right; margin-right: 5px;">结束时间:
              <el-date-picker
                v-model="endDate"
                type="datetime"
                size="mini"
                placeholder="选择日期时间"
                style="width: 180px;"
                default-time="00:00:00">
              </el-date-picker>
            </span>
            <span style="float:right; margin-right: 5px;">开始时间:
              <el-date-picker
                v-model="startDate"
                type="datetime"
                size="mini"
                placeholder="选择日期时间"
                style="width: 180px;"
                default-time="00:00:00">
              </el-date-picker>
            </span>
          </el-col>
        </el-row>
      </div>
      <el-row :gutter="10">
        <el-col :span="12">
          <div>
            <el-row :gutter="10">
              <el-col :span="8">
                <div class="div0">
                  <div class="div00" style="color: red">{{alarm1}}</div>
                  <div class="div01">高级报警</div>
                </div>
              </el-col>
              <el-col :span="8">
                <div class="div0">
                  <div class="div00" style="color: indianred">{{alarm2}}</div>
                  <div class="div01">中级报警</div>
                </div>
              </el-col>
              <el-col :span="8">
                <div class="div0">
                  <div class="div00" style="color: orange">{{alarm3}}</div>
                  <div class="div01">一般报警</div>
                </div>
              </el-col>
            </el-row>
          </div>

        </el-col>
        <el-col :span="12">
          <div id="alarmBar" style="width: 100%; height: 300px; border:none;margin-top: -30px;margin-bottom: -30px"></div>
        </el-col>
      </el-row>
    </el-card>
    <el-card class="box-card" :body-style="cardBody" style="margin-top: 10px; padding-left: 10px;">
      <div slot="header">
        <el-button size =mini @click="dialogVisible = !dialogVisible"><i class="el-icon-info" style="margin-right: 10px"></i>筛选</el-button>
        <el-button size =mini @click="exportExcel" style="float: right"><i class="el-icon-document" style="margin-right: 10px"></i>导出报警</el-button>
        <transition name="select_body_fade">
          <div v-if="dialogVisible" class="select_body">
            <el-form ref="alarmForm" :model="alarmForm" label-width="80px" label-position="left">
              <el-row :gutter="10">
                <el-col :span="12">
                  <el-form-item prop="alarm_type">
                    <div slot="label" class="form-label">报警级别</div>
                    <el-checkbox-group v-model="alarmForm.alarm_type">
                      <el-checkbox label="设备调试" name="alarm_type"></el-checkbox>
                      <el-checkbox label="真实故障" name="alarm_type"></el-checkbox>
                      <el-checkbox label="误报" name="alarm_type"></el-checkbox>
                    </el-checkbox-group>
                  </el-form-item>
                </el-col>
                <el-col :span="12">
                  <el-form-item prop="alarm_result">
                    <div slot="label" class="form-label">报警状态</div>
                    <el-checkbox-group v-model="alarmForm.alarm_result">
                      <el-checkbox label="已确认" name="alarm_type"></el-checkbox>
                      <el-checkbox label="未确认" name="alarm_type"></el-checkbox>
                    </el-checkbox-group>
                  </el-form-item>
                </el-col>
              </el-row>
              <hr class="hr_mr"/>
              <hr class="hr_mr"/>
              <el-row :gutter="10">
                <el-col :span="12">
                  <el-form-item>
                    <div slot="label" class="form-label">日期时间</div>
                    <el-row>
                      <el-col :span="9">
                        <el-form-item prop="alarm_start_time">
                          <el-date-picker
                            v-model="alarmForm.alarm_start_time"
                            type="datetime"
                            placeholder="选择日期时间"
                            default-time="00:00:00"
                            size="mini"
                            style="width: 100%;">
                          </el-date-picker>
                        </el-form-item>
                      </el-col>
                      <el-col :span="2" style="text-align: center">-</el-col>
                      <el-col :span="9">
                        <el-form-item prop="alarm_end_time">
                          <el-date-picker
                            v-model="alarmForm.alarm_end_time"
                            type="datetime"
                            placeholder="选择日期时间"
                            default-time="00:00:00"
                            size="mini"
                            style="width: 100%;">
                          </el-date-picker>
                        </el-form-item>
                      </el-col>
                    </el-row>
                  </el-form-item>
                </el-col>
                <el-col :span="12">
                  <el-form-item prop="alarm_system">
                    <div slot="label" class="form-label">子系统</div>
                    <el-select v-model="alarmForm.alarm_system" placeholder="所有系统" size="mini" style="width:180px;">
                      <el-option label="制冷系统" value="0"></el-option>
                      <el-option label="制暖系统" value="1"></el-option>
                    </el-select>
                  </el-form-item>
                  <el-form-item prop="alarm_eqp">
                    <div slot="label" class="form-label">设备</div>
                    <el-select v-model="alarmForm.alarm_eqp" placeholder="所有设备" size="mini" style="width:180px;">
                      <el-option label="空调" value="0"></el-option>
                      <el-option label="冰箱" value="1"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
              </el-row>
              <hr class="hr_mr"/>
              <hr class="hr_mr"/>
              <el-row :gutter="10">
                <el-col :span="12">
                  <el-form-item prop="alarm_state">
                    <div slot="label" class="form-label">工单状态</div>
                    <el-checkbox-group v-model="alarmForm.alarm_state">
                      <el-checkbox label="未处理" name="alarm_state"></el-checkbox>
                      <el-checkbox label="处理中" name="alarm_state"></el-checkbox>
                      <el-checkbox label="处理完毕" name="alarm_state"></el-checkbox>
                    </el-checkbox-group>
                  </el-form-item>
                </el-col>
                <el-col :span="12">
                  <el-form-item prop="alarm_block">
                    <div slot="label" class="form-label">办公楼</div>
                    <el-select v-model="alarmForm.alarm_block" placeholder="所有办公楼" size="mini" style="width:180px;">
                      <el-option label="1号楼" value="1号楼"></el-option>
                      <el-option label="2号楼" value="2号楼"></el-option>
                    </el-select>
                  </el-form-item>
                  <el-form-item prop="alarm_floor">
                    <div slot="label" class="form-label">楼层</div>
                    <el-select v-model="alarmForm.alarm_floor" placeholder="所有楼层" size="mini" style="width:180px;">
                      <el-option label="1层" value="1层"></el-option>
                      <el-option label="2层" value="2层"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
              </el-row>
              <hr class="hr_mr"/>
              <hr class="hr_mr"/>
              <el-form-item>
                <el-row style="float: right; padding-right: 20px;">
                  <el-button @click="resetForm('alarmForm')" size="mini">重置</el-button>
                  <el-button type="primary" @click="submitForm('alarmForm')" size="mini">确 定</el-button>
                </el-row>
              </el-form-item>
            </el-form>
          </div>
        </transition>
      </div>
      <el-table
        id="alarm-table"
        :data="alarmData"
        style="width: 100%">
        <el-table-column
          label="报警ID"
          prop="alarm_id">
        </el-table-column>
        <el-table-column
          label="报警NO"
          prop="alarm_no">
        </el-table-column>
        <el-table-column
          label="报警类型"
          prop="alarm_type">
        </el-table-column>
        <el-table-column
          label="报警时间"
          prop="alarm_time">
        </el-table-column>
        <el-table-column
          label="上报人员"
          prop="people_name">
        </el-table-column>
        <el-table-column
          label="报警详细"
          prop="alarm_desc">
        </el-table-column>
        <el-table-column>
          <template slot-scope="scope">
            <el-button
              type="text"
              @click="handleLocation(scope.$index, scope.row)"><i class="el-icon-location"></i></el-button>
            <el-button
              size="mini"
              type="text"
              @click="handleOk(scope.$index, scope.row)" style="text-decoration: underline">
              <i class="el-icon-check"></i>确认报警</el-button>
          </template>
        </el-table-column>
      </el-table>
      <el-row style="margin-top: 10px;margin-bottom: 10px;">
        <!--<span style="float: left; font-size: 13px;margin-left: 20px;">-->
          <!--每页显示：-->
          <!--<el-select v-model="orderNumber" placeholder="请选择" @change="handleSizeChange" size="mini" style="width:70px;">-->
            <!--<el-option-->
              <!--v-for="item in options"-->
              <!--:key="item.value"-->
              <!--:label="item.label"-->
              <!--:value="item.value">-->
            <!--</el-option>-->
          <!--</el-select>-->
        <!--</span>-->
        <el-row type="flex" justify="center">
          <!--<el-pagination-->
            <!--@current-change="handleCurrentChange"-->
            <!--@size-change="handleSizeChange"-->
            <!--small-->
            <!--:page-size="10"-->
            <!--:page-sizes="[10, 20, 30, 50]"-->
            <!--:pager-count="11"-->
            <!--layout="total, size, prev, pager, next, jumper"-->
            <!--:current-page="currentPage+1"-->
            <!--:total="getTotal">-->
          <!--</el-pagination>-->
          <el-pagination
            @size-change="handleSizeChange"
            @current-change="handleCurrentChange"
            small
            :current-page="currentPage+1"
            :page-sizes="[10, 20, 30, 50]"
            :page-size="10"
            layout="total, sizes, prev, pager, next, jumper"
            :total="getTotal">
          </el-pagination>
        </el-row>
      </el-row>
    </el-card>
  </div>
</template>

<script>
// import XLSX from 'xlsx'
// import FileSaver from 'file-saver'
export default {
  name: 'alarm',
  data () {
    return {
      searchText: '',
      cardBody: {
        padding: '0px'
      },
      startDate: '',
      endDate: '',
      isActive: 0,
      alarm1: 10,
      alarm2: 8,
      alarm3: 2,
      alarm4: [12, 5, 3, 17],
      alarmDataSource: [{
        alarm_id: '1',
        alarm_no: '12345',
        alarm_type: '误报',
        alarm_time: '2018-10-19 12:12:13',
        people_name: '大牛',
        alarm_desc: '一号楼发电机异常'
      }, {
        alarm_id: '2',
        alarm_no: '12346',
        alarm_type: '误报',
        alarm_time: '2018-10-19 12:12:13',
        people_name: '大牛',
        alarm_desc: '一号楼发电机异常'
      }, {
        alarm_id: '3',
        alarm_no: '12347',
        alarm_type: '真实故障',
        alarm_time: '2018-10-19 12:12:13',
        people_name: '大牛',
        alarm_desc: '二号楼发电机异常'
      }, {
        alarm_id: '4',
        alarm_no: '12348',
        alarm_type: '真实故障',
        alarm_time: '2018-10-19 12:12:13',
        people_name: '大牛',
        alarm_desc: '三号楼发电机异常'
      }],
      alarmData: [{
        alarm_id: '1',
        alarm_no: '12345',
        alarm_type: '误报',
        alarm_time: '2018-10-19 12:12:13',
        people_name: '大牛',
        alarm_desc: '一号楼发电机异常'
      }, {
        alarm_id: '2',
        alarm_no: '12346',
        alarm_type: '误报',
        alarm_time: '2018-10-19 12:12:13',
        people_name: '大牛',
        alarm_desc: '一号楼发电机异常'
      }, {
        alarm_id: '3',
        alarm_no: '12347',
        alarm_type: '真实故障',
        alarm_time: '2018-10-19 12:12:13',
        people_name: '大牛',
        alarm_desc: '二号楼发电机异常'
      }, {
        alarm_id: '4',
        alarm_no: '12348',
        alarm_type: '真实故障',
        alarm_time: '2018-10-19 12:12:13',
        people_name: '大牛',
        alarm_desc: '三号楼发电机异常'
      }],
      options: [{
        label: '10',
        value: 10
      }, {
        label: '15',
        value: 15
      }, {
        label: '20',
        value: 20
      }, {
        label: '30',
        value: 30
      }, {
        label: '50',
        value: 50
      }],
      orderNumber: 10,
      getTotal: 4,
      currentPage: 0,
      dialogVisible: false,
      alarmForm: {
        alarm_type: [],
        alarm_result: [],
        alarm_start_time: '',
        alarm_end_time: '',
        alarm_system: '',
        alarm_eqp: '',
        alarm_state: [],
        alarm_block: '',
        alarm_floor: ''
      }
    }
  },
  methods: {
    drawAlarmBar () {
      let alarmBar = this.$echarts.init(document.getElementById('alarmBar'))
      let option = {
        color: [ '#888888' ],
        tooltip: {
          trigger: 'axis',
          axisPointer: {
            type: 'shadow'
          }
        },
        xAxis: {
          type: 'value',
          show: false,
          axisLine: {
            show: false
          }
        },
        yAxis: {
          type: 'category',
          data: ['其他', '误报', '真实故障', '设备调试'],
          axisLine: {
            show: false
          },
          axisTick: {
            show: false
          }
        },
        series: [
          {
            name: 'alarm',
            type: 'bar',
            data: this.alarm4,
            label: {
              show: true,
              position: 'right'
            }
          }
        ]
      }
      alarmBar.setOption(option)
      alarmBar.resize()
    },
    timeItemChange (val) {
      this.isActive = val
      if (val === 0) {
        this.alarm1 = 10
        this.alarm2 = 8
        this.alarm3 = 2
        this.alarm4 = [12, 5, 3, 17]
      } else if (val === 1) {
        this.alarm1 = 18
        this.alarm2 = 24
        this.alarm3 = 22
        this.alarm4 = [18, 22, 13, 47]
      } else if (val === 2) {
        this.alarm1 = 78
        this.alarm2 = 264
        this.alarm3 = 134
        this.alarm4 = [55, 42, 67, 187]
      } else if (val === 3) {
        this.alarm1 = 257
        this.alarm2 = 424
        this.alarm3 = 522
        this.alarm4 = [234, 432, 627, 256]
      }
      this.drawAlarmBar()
    },
    handleLocation (index, row) {
      console.log(index, row)
      this.$router.push({ name: 'gis' })
    },
    handleOk (index, row) {
      console.log(index, row)
    },
    handleCurrentChange (val) {
      console.log(`当前页: ${val}`)
      this.currentPage = val - 1
    },
    handleSizeChange (val) {
      console.log(`每页 ${val} 条`)
      this.orderNumber = val
      this.currentPage = 0
    },
    handleClose (done) {
      this.$confirm('确认关闭？')
        .then(_ => {
          done()
        })
        .catch(_ => {})
    },
    submitForm (formNane) {
      this.alarmData = []
      for (let x in this.alarmDataSource) {
        for (let y in this.alarmForm.alarm_type) {
          if (this.alarmDataSource[x].alarm_type === this.alarmForm.alarm_type[y]) {
            this.alarmData.push(this.alarmDataSource[x])
          }
        }
      }
      this.dialogVisible = false
      console.log(this.alarmForm)
    },
    resetForm (formName) {
      this.$refs[formName].resetFields()
      // this.dialogVisible = false
    },
    exportExcel () {
      // /* generate workbook object from table */
      // var wb = XLSX.utils.table_to_book(document.querySelector('#alarm-table'))
      // /* get binary string as output */
      // var wbout = XLSX.write(wb, { bookType: 'xlsx', bookSST: true, type: 'array' })
      // try {
      //   FileSaver.saveAs(new Blob([wbout], { type: 'application/octet-stream' }), 'alarm.xlsx')
      // } catch (e) { if (typeof console !== 'undefined') console.log(e, wbout) }
      // return wbout
    }
  },
  mounted () {
    this.drawAlarmBar()
  }
}
</script>

<style scoped>
  .div0 {
    width: 100%;
    height: 240px;
    border-width: 2px;
    border-right-style: solid;
    text-align: center;
  }

  .div00 {
    margin: auto;
    width: 50%;
    height: 130px;
    font-size: 50px;
    font-weight: bold;
    text-align: center;
    padding-top: 70px;
  }
  .div01 {
    padding: 10px;
    font-size: 15px;
    font-weight: bold;
  }

  .active {
    color: white;
    background-color: lightskyblue;
  }

  .timeItem {
    border: solid 1px #aaaaaa;
    width: 100px;
    height: 23px;
    text-align: center;
    display: inline-block;
    margin-left: -3px;
    cursor:pointer;
    font-size: 19px;
  }

  .form-label {
    font-weight: bold;
  }

  .hr_mr {
    margin-top: -14px;
  }

  .el-dialog__header {
    padding: 20px;
    background-color: lightskyblue;
  }

  .select_body {
    width: 100%;
    /* height: 550px; */
    margin-top: 10px;
    border: 1px #eee solid;
    padding: 20px;
  }

  .select_body_fade-enter-active, .select_body_fade-leave-active {
    transition: opacity .5s;
  }
  .select_body_fade-enter, .select_body_fade-leave-to /* .fade-leave-active below version 2.1.8 */ {
    opacity: 0;
  }
</style>
