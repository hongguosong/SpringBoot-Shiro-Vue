<template>
  <div id="carAlias">
    <el-row :gutter="20">
      <el-col :span="16" class="grid-content bg-purple-dark">
        <el-row>
          <el-col :span="12">
            <span class="title">总体概况</span>
            <el-button type="text" style="margin-left: 10px;" @click="carChange('day')">一天</el-button>
            <el-button type="text" @click="carChange('week')">一周</el-button>
            <el-button type="text" @click="carChange('month')">一月</el-button>
          </el-col>
          <el-col :span="12">
            <el-row type="flex" justify="end">
              <el-input v-model="input" placeholder="全部停车场" size="mini" style="width: 150px;"></el-input>
              <el-button style="margin-left: 10px;" size="mini" @click="getCarFlow">搜索</el-button>
            </el-row>
          </el-col>
        </el-row>
        <el-row :gutter="10">
          <el-col :span="6">
            <div style="background-color: lightblue; padding: 5px;border-radius: 10px;">
              <div style="text-align: center; padding: 5px;">今日流水</div>
              <div style="color: #1e90ff; font-size: 20px;text-align: center;padding: 5px;">{{flowCar}}<span style="font-size: 12px; margin-left: 5px;">辆</span></div>
              <div style="text-align: center; padding: 5px;">+28<span style="font-size: 12px; margin-left: 5px;">辆</span></div>
            </div>
          </el-col>
          <el-col :span="6">
            <div style="background-color: lightgreen; padding: 5px;border-radius: 10px;">
              <div style="text-align: center; padding: 5px;">今日进场车辆</div>
              <div style="color: green; font-size: 20px;text-align: center;padding: 5px;">{{inCar}}<span style="font-size: 12px; margin-left: 5px;">辆</span></div>
              <div style="text-align: center; padding: 5px;">+28<span style="font-size: 12px; margin-left: 5px;">辆</span></div>
            </div>
          </el-col>
          <el-col :span="6">
            <div style="background-color: orange; padding: 5px;border-radius: 10px;">
              <div style="text-align: center; padding: 5px;">今日出场车辆</div>
              <div style="color: yellow; font-size: 20px;text-align: center;padding: 5px;">{{outCar}}<span style="font-size: 12px; margin-left: 5px;">辆</span></div>
              <div style="text-align: center; padding: 5px;">+28<span style="font-size: 12px; margin-left: 5px;">辆</span></div>
            </div>
          </el-col>
          <el-col :span="6">
            <div style="background-color: lightpink; padding: 5px;border-radius: 10px;">
              <div style="text-align: center; padding: 5px;">异常车流量</div>
              <div style="color: red; font-size: 20px;text-align: center;padding: 5px;">{{abnormalCar}}<span style="font-size: 12px; margin-left: 5px;">辆</span></div>
              <div style="text-align: center; padding: 5px;">+28<span style="font-size: 12px; margin-left: 5px;">辆</span></div>
            </div>
          </el-col>
        </el-row>
        <el-row style="margin-top: 15px;">
          <el-col :span="24">
            <span class="title">车流车辆情况</span>
          </el-col>
        </el-row>
        <el-row :gutter="10" style="margin-top: 15px;">
          <el-col :span="12">
            <div id="carportChart" style="width: 100%; height: 300px; background-color: #eeeeee"></div>
          </el-col>
          <el-col :span="12">
            <div id="flowChart" style="width: 100%; height: 300px; background-color: #eeeeee"></div>
          </el-col>
        </el-row>
        <el-row style="margin-top: 15px;">
          <el-col :span="24">
            <span class="title">变化情况</span>
          </el-col>
        </el-row>
        <el-row :gutter="10" style="margin-top: 15px;">
          <el-col :span="12">
            <div id="moneyChart" style="width: 100%; height: 300px; background-color: #eeeeee"></div>
          </el-col>
          <el-col :span="12">
            <div id="carChart" style="width: 100%; height: 300px; background-color: #eeeeee"></div>
          </el-col>
        </el-row>
        <el-row style="margin-top: 15px;">
          <el-col :span="24">
            <span class="title">构成情况</span>
          </el-col>
        </el-row>
        <el-row :gutter="0" style="margin-top: 15px">
          <el-col :span="6">
            <div id="allMoneyDoughnut" style="width: 100%; height: 360px; background-color: #eeeeee"></div>
          </el-col>
          <el-col :span="6">
            <div id="distributeMoneyDoughnut" style="width: 100%; height: 360px; background-color: #eeeeee"></div>
          </el-col>
          <el-col :span="6">
            <div id="carCountDoughnut" style="width: 100%; height: 360px; background-color: #eeeeee"></div>
          </el-col>
          <el-col :span="6">
            <div id="carTimeDoughnut" style="width: 100%; height: 360px; background-color: #eeeeee"></div>
          </el-col>
        </el-row>
      </el-col>
      <el-col :span="8" class="grid-content bg-purple-dark">
        <el-row>
          <el-col :span="12">
            <span class="title">收入排名</span>
          </el-col>
          <el-col :span="12">
            <el-row type="flex" justify="end">
              <el-button size="mini">全部<i class="el-icon-d-arrow-right"></i></el-button>
            </el-row>
          </el-col>
        </el-row>
        <el-row style="margin-top: 10px;">
          <el-col :span="24">
            <el-table
              :data="moneyTableData"
              border
              style="width: 100%"
              size="mini">
              <el-table-column
                prop="id"
                label="排名"
                width="100">
              </el-table-column>
              <el-table-column
                prop="name"
                label="停车站"
                width="100">
              </el-table-column>
              <el-table-column
                prop="money"
                label="今日收入(元)">
              </el-table-column>
            </el-table>
          </el-col>
        </el-row>
        <el-row style="margin-top: 10px;">
          <el-col :span="12">
            <span class="title">车流排名</span>
          </el-col>
          <el-col :span="12">
            <el-row type="flex" justify="end">
              <el-button size="mini">全部<i class="el-icon-d-arrow-right"></i></el-button>
            </el-row>
          </el-col>
        </el-row>
        <el-row style="margin-top: 10px;">
          <el-col :span="24">
            <el-table
              :data="carTableData"
              border
              style="width: 100%"
              size="mini">
              <el-table-column
                prop="id"
                label="排名"
                width="100">
              </el-table-column>
              <el-table-column
                prop="nameMax"
                label="最繁忙"
                width="100">
              </el-table-column>
              <el-table-column
                prop="count"
                label="排名(辆)"
                width="100">
              </el-table-column>
              <el-table-column
                prop="nameMin"
                label="最空闲">
              </el-table-column>
            </el-table>
          </el-col>
        </el-row>
        <el-row style="margin-top: 10px;">
          <el-col :span="12">
            <span class="title">设备报警</span>
          </el-col>
          <el-col :span="12">
            <el-row type="flex" justify="end">
              <el-button size="mini">全部<i class="el-icon-d-arrow-right"></i></el-button>
            </el-row>
          </el-col>
        </el-row>
        <el-row style="margin-top: 10px;">
          <el-col :span="24">
            <el-table
              :data="alarmTableData"
              border
              style="width: 100%"
              size="mini">
              <el-table-column
                prop="id"
                label="编号"
                width="100">
              </el-table-column>
              <el-table-column
                prop="name"
                label="停车场"
                width="100">
              </el-table-column>
              <el-table-column
                prop="position"
                label="报警位置"
                width="100">
              </el-table-column>
              <el-table-column
                prop="eqp"
                label="报警设备">
              </el-table-column>
            </el-table>
          </el-col>
        </el-row>
      </el-col>
    </el-row>
  </div>
</template>

<script>
// import { mapGetters } from 'vuex'
export default {
  name: 'car',
  data () {
    return {
      carportChart: null,
      input: '',
      inCar: 116,
      outCar: 99,
      abnormalCar: 20,
      moneyTableData: [
        { id: 1, name: '西漳停车站', money: 1238 },
        { id: 2, name: '北碚停车站', money: 1238 },
        { id: 3, name: '水土停车站', money: 1238 }
      ],
      carTableData: [
        { id: 1, nameMax: '西漳停车站', count: 1238, nameMin: '北碚停车站' },
        { id: 2, nameMax: '西漳停车站', count: 1238, nameMin: '北碚停车站' },
        { id: 3, nameMax: '西漳停车站', count: 1238, nameMin: '北碚停车站' }
      ],
      alarmTableData: [
        { id: 1, name: '西漳停车站', position: '一号出口', eqp: '停车泵' },
        { id: 2, name: '西漳停车站', position: '一号出口', eqp: '停车泵' },
        { id: 3, name: '西漳停车站', position: '一号出口', eqp: '停车泵' }
      ],
      carportData: [
        [1000, 2000, 3000],
        [5000, 4000, 9000]
      ],
      flowChartData: [
        [12, 27, 100, 56, 77, 89, 23, 12, 78, 54, 30, 99, 32, 66, 23, 88, 58, 38, 65, 78, 94, 22, 54, 87],
        [16, 33, 100, 56, 77, 89, 23, 12, 78, 88, 58, 38, 65, 78, 94, 22, 54, 87, 54, 30, 99, 32, 66, 23],
        [15, 30, 100, 56, 99, 32, 66, 23, 88, 58, 38, 65, 77, 89, 23, 12, 78, 54, 30, 78, 94, 22, 54, 87],
        [10, 20, 30, 99, 32, 66, 23, 88, 58, 38, 65, 78, 100, 56, 77, 89, 23, 12, 78, 54, 94, 22, 54, 87]
      ],
      moneyChartData: {
        '10-1': 82, '10-2': 93, '10-3': 90, '10-4': 93, '10-5': 129, '10-6': 13, '10-7': 12
      },
      carChartData: [
        { '10-1': 82, '10-2': 93, '10-3': 90, '10-4': 93, '10-5': 129, '10-6': 13, '10-7': 12 },
        { '10-1': 220, '10-2': 193, '10-3': 50, '10-4': 40, '10-5': 229, '10-6': 193, '10-7': 128 }
      ],

      allMoneyDoughnutData: [
        { value: 33500, name: '线下缴费' },
        { value: 31000, name: '线上缴费' }
      ],
      distributeMoneyDoughnutData: [
        { value: 335, name: '0元' },
        { value: 310, name: '0-5元' },
        { value: 35, name: '5-10元' },
        { value: 65, name: '10-20元' },
        { value: 85, name: '20元以上' }
      ],
      carCountDoughnutData: [
        { value: 235, name: '临时车' },
        { value: 1390, name: '固定车' }
      ],
      carTimeDoughnutData: [
        { value: 335, name: '0.5小时内' },
        { value: 310, name: '0.5-1个小时' },
        { value: 35, name: '1-2个小时' },
        { value: 65, name: '2-3个小时' },
        { value: 85, name: '4小时以上' }
      ]
    }
  },
  computed: {
    getIsCollapse () {
      return this.$store.state.app.sidebar.opened
    },
    flowCar: function () {
      return this.inCar + this.outCar + this.abnormalCar
    }
  },
  watch: {
    getIsCollapse: function (is) {
      if (is === true || is === false) {
        var that = this
        setTimeout(
          function () {
            that.temp()
          }, 300)
      }
    }
  },
  methods: {
    carChange: function (item) {
      if (item === 'day') {
        this.inCar = 200
        this.outCar = 100
        this.abnormalCar = 20
      } else if (item === 'week') {
        this.inCar = 2000
        this.outCar = 1800
        this.abnormalCar = 600
      } else if (item === 'month') {
        this.inCar = 58900
        this.outCar = 55000
        this.abnormalCar = 3400
      }
    },
    getCarFlow: function () {
      var that = this
      this.$ajax({
        method: 'post',
        url: '/api/flow/getCarFlow',
        contentType: 'application/json; charset=utf-8',
        data: that.input
      }).then(function (response) {
        that.inCar = response.data.inCar
        that.outCar = response.data.outCar
        that.abnormalCar = response.data.abnormalCar
      }).catch(function (response) {
        that.$message.error(response)
      })
    },
    drawCarportChart: function () {
      // this.carportChart = this.$echarts.init(document.getElementById('carportChart'))
      let y1 = this.carportData[0]
      let y2 = this.carportData[1]
      this.carportChart.setOption({
        color: ['#7CCD7C', '#8470FF', '#4cabce', '#e5323e'],
        title: {
          text: '车位车流实时动态图',
          textStyle: {
            fontSize: 15
          },
          left: 'right',
          top: '30'
        },
        grid: {
          left: '50'
        },
        legend: {
          // type: 'scroll',
          // orient: 'vertical',
          // right: 10,
          // top: 20,
          // bottom: 20,
          data: ['已用车位', '空闲车位']
        },
        tooltip: {
          trigger: 'axis',
          axisPointer: {
            type: 'shadow'
          }
        },
        calculable: true,
        xAxis: [
          {
            type: 'category',
            axisTick: { show: false },
            data: ['固定', '非固定', '0h~24h实时']
          }
        ],
        yAxis: [
          {
            type: 'value',
            max: 12000,
            min: 0
          }
        ],
        series: [
          {
            name: '已用车位',
            type: 'bar',
            barGap: 0,
            label: {
              show: true,
              position: 'top'
            },
            data: y1
          },
          {
            name: '空闲车位',
            type: 'bar',
            label: {
              show: true,
              position: 'top'
            },
            data: y2
          }
          // {
          //   name: '累计车流量/日',
          //   type: 'line',
          //   data: y3
          // }
        ]
      })
      this.carportChart.resize()
    },
    drawFlowChart: function () {
      let flowChart = this.$echarts.init(document.getElementById('flowChart'))
      let that = this
      flowChart.setOption({
        color: ['#7CCD7C', '#8470FF', '#4cabce', '#e5323e'],
        title: {
          text: '车流量',
          textStyle: {
            fontSize: 15
          },
          left: 'right',
          top: '30'
        },
        legend: {
          // type: 'scroll',
          // orient: 'vertical',
          // right: 10,
          // top: 20,
          // bottom: 20,
          data: ['南进口量', '北进口量', '西进口量', '东进口量']
        },
        tooltip: {
          trigger: 'axis',
          axisPointer: {
            type: 'shadow'
          }
        },
        calculable: true,
        xAxis: [
          {
            type: 'category',
            axisTick: { show: false },
            data: ['0h~1h', '1h~2h', '2h~3h', '3h~4h', '4h~15', '5h~6h',
              '6h~7h', '7h~8h', '8h~9h', '9h~10h', '10h~11', '11h~12h',
              '12h~13h', '13h~14h', '14h~15h', '15h~16h', '16h~17h', '17h~18h',
              '18h~19h', '19h~20h', '20h~21h', '21h~22h', '22h~23h', '23h~24h'],
            axisLabel: {
              rotate: 45
            }
          }
        ],
        yAxis: [
          {
            type: 'value',
            name: '流量(pcu/h)'
          }
        ],
        series: [
          {
            name: '南进口量',
            type: 'line',
            barGap: 0,
            data: that.flowChartData[0]
          },
          {
            name: '北进口量',
            type: 'line',
            data: that.flowChartData[1]
          },
          {
            name: '西进口量',
            type: 'line',
            data: that.flowChartData[2]
          },
          {
            name: '东进口量',
            type: 'line',
            data: that.flowChartData[3]
          }
        ]
      })
      flowChart.resize()
    },
    drawMoneyChart: function () {
      let moneyChart = this.$echarts.init(document.getElementById('moneyChart'))
      let x = []
      let y = []
      for (let a in this.moneyChartData) {
        x.push(a)
        y.push(this.moneyChartData[a])
      }
      moneyChart.setOption({
        title: {
          text: '过去七日流水',
          textStyle: {
            fontSize: 15
          },
          left: 'right',
          top: '30'
        },
        tooltip: {
          trigger: 'axis',
          axisPointer: {
            type: 'cross',
            label: {
              backgroundColor: '#6a7985'
            }
          }
        },
        xAxis: {
          type: 'category',
          boundaryGap: false,
          // data: ['6-6', '6-7', '6-8', '6-9', '6-10', '6-11', '6-12']
          data: x
        },
        yAxis: {
          type: 'value',
          name: '流水(千元)'
        },
        series: [{
          // data: [ 82, 93, 90, 93, 129, 13, 12 ],
          data: y,
          type: 'line',
          areaStyle: {}
        }],
        color: [
          '#87CEFF'
        ]
      })
      moneyChart.resize()
    },
    drawCarChart: function () {
      let carChart = this.$echarts.init(document.getElementById('carChart'))
      let x = []
      let y1 = []
      let y2 = []
      for (let a in this.carChartData[0]) {
        x.push(a)
        y1.push(this.carChartData[0][a])
      }
      for (let b in this.carChartData[1]) {
        y2.push(this.carChartData[1][b])
      }

      carChart.setOption({
        color: ['#7CCD7C', '#8470FF', '#4cabce', '#e5323e'],
        title: {
          text: '过去七日车流构成',
          textStyle: {
            fontSize: 15
          },
          left: 'right',
          top: '30'
        },
        tooltip: {
          trigger: 'axis',
          axisPointer: {
            type: 'shadow'
          }
        },
        calculable: true,
        xAxis: [
          {
            type: 'category',
            axisTick: { show: false },
            // data: ['6-6', '6-7', '6-8', '6-9', '6-10', '6-11', '6-12']
            data: x
          }
        ],
        yAxis: [
          {
            type: 'value'
          }
        ],
        series: [
          {
            name: '临时车',
            type: 'bar',
            barGap: 0,
            // data: [320, 332, 301, 334, 390, 330, 120]
            data: y1
          },
          {
            name: '长时车',
            type: 'bar',
            // data: [220, 182, 191, 234, 290, 340, 230]
            data: y2
          }
        ]
      })
      carChart.resize()
    },
    drawAllMoneyDoughnut: function () {
      let allMoneyDoughnut = this.$echarts.init(document.getElementById('allMoneyDoughnut'))
      let all = 0
      for (let a in this.allMoneyDoughnutData) {
        all += this.allMoneyDoughnutData[a].value
      }
      let option = {
        title: {
          text: '总收入构成',
          textStyle: {
            fontSize: 15
          },
          left: 'center',
          top: 10
        },
        tooltip: {
          trigger: 'item',
          formatter: '{a} <br/>{b}: {c} ({d}%)'
        },
        series: [
          {
            name: '访问来源',
            type: 'pie',
            radius: ['50%', '70%'],
            center: ['50%', '39%'],
            avoidLabelOverlap: false,
            label: {
              normal: {
                show: true,
                position: 'center',
                formatter: function (argument) {
                  var html
                  html = all + '\r\n' + '元'
                  return html
                },
                textStyle: {
                  fontSize: 15,
                  color: '#39CCCC'
                }
              }
            },
            labelLine: {
              normal: {
                show: false
              }
            },
            data: this.allMoneyDoughnutData
          }
        ],
        legend: {
          orient: 'vertical',
          x: 'left',
          data: [
            { name: '线下缴费', icon: 'circle' },
            { name: '线上缴费', icon: 'circle' }
          ],
          bottom: 'top',
          left: 'center',
          formatter: function (name) {
            if (name === '线下缴费') {
              return '线下缴费: ' + option.series[0].data[0].value + '元'
            } else if (name === '线上缴费') {
              return '线上缴费: ' + option.series[0].data[1].value + '元'
            }
          }
        },
        color: [
          '#836FFF', '#7CCD7C', '#7D26CD', '#B3EE3A', '#CD69C9'
        ]
      }
      allMoneyDoughnut.setOption(option)
      allMoneyDoughnut.resize()
    },
    drawDistributeMoneyDoughnut: function () {
      let distributeMoneyDoughnut = this.$echarts.init(document.getElementById('distributeMoneyDoughnut'))
      let all = 0
      for (let a in this.distributeMoneyDoughnutData) {
        all += this.distributeMoneyDoughnutData[a].value
      }
      let option = {
        title: {
          text: '收费金额分布',
          textStyle: {
            fontSize: 15
          },
          left: 'center',
          top: 10
        },
        tooltip: {
          trigger: 'item',
          formatter: '{a} <br/>{b}: {c} ({d}%)'
        },
        legend: {
          orient: 'vertical',
          data: [
            { name: '0元', icon: 'circle' },
            { name: '0-5元', icon: 'circle' },
            { name: '5-10元', icon: 'circle' },
            { name: '10-20元', icon: 'circle' },
            { name: '20元以上', icon: 'circle' }
          ],
          bottom: 'top',
          left: 'center',
          formatter: function (name) {
            if (name === '0元') {
              return name + ': ' + option.series[0].data[0].value + '元'
            } else if (name === '0-5元') {
              return name + ': ' + option.series[0].data[1].value + '元'
            } else if (name === '5-10元') {
              return name + ': ' + option.series[0].data[2].value + '元'
            } else if (name === '10-20元') {
              return name + ': ' + option.series[0].data[3].value + '元'
            } else if (name === '20元以上') {
              return name + ': ' + option.series[0].data[4].value + '元'
            }
          }
        },
        series: [
          {
            name: '访问来源',
            type: 'pie',
            radius: ['50%', '70%'],
            center: ['50%', '39%'],
            avoidLabelOverlap: false,
            label: {
              normal: {
                show: true,
                position: 'center',
                formatter: function (argument) {
                  var html
                  html = all
                  return html
                },
                textStyle: {
                  fontSize: 15,
                  color: '#39CCCC'
                }
              }
            },
            labelLine: {
              normal: {
                show: false
              }
            },
            data: this.distributeMoneyDoughnutData
          }
        ],
        color: [
          '#836FFF', '#7CCD7C', '#7D26CD', '#B3EE3A', '#CD69C9'
        ]
      }
      distributeMoneyDoughnut.setOption(option)
      distributeMoneyDoughnut.resize()
    },
    drawCarCountDoughnut: function () {
      let carCountDoughnut = this.$echarts.init(document.getElementById('carCountDoughnut'))
      let all = 0
      for (let a in this.carCountDoughnutData) {
        all += this.carCountDoughnutData[a].value
      }
      let option = {
        title: {
          text: '总流量构成',
          textStyle: {
            fontSize: 15
          },
          left: 'center',
          top: 10
        },
        tooltip: {
          trigger: 'item',
          formatter: '{a} <br/>{b}: {c} ({d}%)'
        },
        legend: {
          orient: 'vertical',
          data: [
            { name: '临时车', icon: 'circle' },
            { name: '固定车', icon: 'circle' }
          ],
          bottom: 'top',
          left: 'center',
          formatter: function (name) {
            if (name === '临时车') {
              return name + ': ' + option.series[0].data[0].value
            } else if (name === '固定车') {
              return name + ': ' + option.series[0].data[1].value
            }
          }
        },
        series: [
          {
            name: '访问来源',
            type: 'pie',
            radius: ['50%', '70%'],
            center: ['50%', '39%'],
            avoidLabelOverlap: false,
            label: {
              normal: {
                show: true,
                position: 'center',
                formatter: function (argument) {
                  var html
                  html = all
                  return html
                },
                textStyle: {
                  fontSize: 15,
                  color: '#39CCCC'
                }
              }
            },
            labelLine: {
              normal: {
                show: false
              }
            },
            data: this.carCountDoughnutData
          }
        ],
        color: [
          '#836FFF', '#7CCD7C', '#7D26CD', '#B3EE3A', '#CD69C9'
        ]
      }
      carCountDoughnut.setOption(option)
      carCountDoughnut.resize()
    },
    drawCarTimeDoughnut: function () {
      let carTimeDoughnut = this.$echarts.init(document.getElementById('carTimeDoughnut'))
      let all = 0
      for (let a in this.carTimeDoughnutData) {
        all += this.carTimeDoughnutData[a].value
      }
      let option = {
        title: {
          text: '收费金额分布',
          textStyle: {
            fontSize: 15
          },
          left: 'center',
          top: 10
        },
        tooltip: {
          trigger: 'item',
          formatter: '{a} <br/>{b}: {c} ({d}%)'
        },
        legend: {
          orient: 'vertical',
          data: [
            { name: '0.5小时内', icon: 'circle' },
            { name: '0.5-1个小时', icon: 'circle' },
            { name: '1-2个小时', icon: 'circle' },
            { name: '2-3个小时', icon: 'circle' },
            { name: '4小时以上', icon: 'circle' }
          ],
          bottom: 'top',
          left: 'center',
          formatter: function (name) {
            if (name === '0.5小时内') {
              return name + ': ' + option.series[0].data[0].value
            } else if (name === '0.5-1个小时') {
              return name + ': ' + option.series[0].data[1].value
            } else if (name === '1-2个小时') {
              return name + ': ' + option.series[0].data[2].value
            } else if (name === '2-3个小时') {
              return name + ': ' + option.series[0].data[3].value
            } else if (name === '4小时以上') {
              return name + ': ' + option.series[0].data[4].value
            }
          }
        },
        series: [
          {
            name: '访问来源',
            type: 'pie',
            radius: ['50%', '70%'],
            center: ['50%', '39%'],
            avoidLabelOverlap: false,
            label: {
              normal: {
                show: true,
                position: 'center',
                formatter: function (argument) {
                  var html
                  html = all
                  return html
                },
                textStyle: {
                  fontSize: 15,
                  color: '#39CCCC'
                }
              }
            },
            labelLine: {
              normal: {
                show: false
              }
            },
            data: this.carTimeDoughnutData
          }
        ],
        color: [
          '#836FFF', '#7CCD7C', '#7D26CD', '#B3EE3A', '#CD69C9'
        ]
      }
      carTimeDoughnut.setOption(option)
      carTimeDoughnut.resize()
    },
    temp: function () {
      this.drawCarportChart()
      this.drawFlowChart()
      this.drawMoneyChart()
      this.drawCarChart()
      this.drawAllMoneyDoughnut()
      this.drawDistributeMoneyDoughnut()
      this.drawCarCountDoughnut()
      this.drawCarTimeDoughnut()
    }
  },
  mounted () {
    this.carportChart = this.$echarts.init(document.getElementById('carportChart'))
    this.temp()
    window.onresize = this.temp
    var that = this
    setInterval(function () {
      if (that.carportData[1][0] > 50 && that.carportData[1][1] > 50) {
        that.carportData[0][0] += Math.round(Math.random() * 20) + 30
        that.carportData[0][1] += Math.round(Math.random() * 20) + 30
        that.carportData[1][0] = 6000 - that.carportData[0][0]
        that.carportData[1][1] = 6000 - that.carportData[0][1]
        that.carportData[0][2] = that.carportData[0][0] + that.carportData[0][1]
        that.carportData[1][2] = that.carportData[1][0] + that.carportData[1][1]
        that.drawCarportChart()
      }
      that.inCar += 1
    },
    3000)
    setInterval(function () {
      that.outCar += 1
    },
    4000)
  }
}
</script>

<style scoped>
  .title {
    font-size: 20px;
  }
  .el-button {
    text-decoration: underline;
  }
</style>
