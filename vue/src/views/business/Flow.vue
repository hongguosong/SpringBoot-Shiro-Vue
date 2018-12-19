<template>
  <div id="flow">
    <el-row>
      <div class="font4">节假日客流量分析</div>
    </el-row>
    <el-row :gutter="5">
      <el-col :span="9">
        <el-row>
          <div class="back4">
            <div>节假日日均客流量</div>
            <el-table
              :data="flowTableData"
              style="width: 100%;"
              size="mini"
              :row-style="tableRowStyle"
              :header-cell-style="tableHeaderColor"
              :cell-style="tableCellStyle">
              <el-table-column
                prop="date"
                label="节假日">
              </el-table-column>
              <el-table-column
                prop="flow"
                label="日均客流量">
              </el-table-column>
              <el-table-column
                prop="in"
                label="日均进店率">
              </el-table-column>
              <el-table-column
                prop="order"
                label="日均订单量">
              </el-table-column>
              <el-table-column
                prop="success"
                label="日均成交率">
              </el-table-column>
              <el-table-column
                prop="money"
                label="日均销售额">
              </el-table-column>
            </el-table>
          </div>
        </el-row>
        <el-row style="margin-top: 5px;">
          <div id="orderChart" style="width: 100%; height: 373px; background-color: #212138; border:none;"></div>
        </el-row>
        <el-row></el-row>
      </el-col>
      <el-col :span="15">
        <el-row :gutter="5">
          <el-col :span="4-8">
            <div class="back5">
              <div style="text-align: center; color: yellow; padding: 20px;">日均客流量</div>
              <div style="text-align: center">
                <el-row>
                  <el-col :span="12"><span style="color: #aaaaaa; font-size: 12px">节假日</span></el-col>
                  <el-col :span="12">8909</el-col>
                </el-row>
              </div>
              <div style="width: 99%; border: solid 1px yellow;"></div>
              <div style="text-align: center">
                <el-row>
                  <el-col :span="12"><span style="color: #aaaaaa; font-size: 12px">日常</span></el-col>
                  <el-col :span="12">8909.34</el-col>
                </el-row>
              </div>
            </div>
          </el-col>
          <el-col :span="4-8">
            <div class="back5">
              <div style="text-align: center; color: dodgerblue; padding: 20px;">日均进店率</div>
              <div style="text-align: center">
                <el-row>
                  <el-col :span="11"><span style="color: #aaaaaa; font-size: 12px">节假日</span></el-col>
                  <el-col :span="13">8909</el-col>
                </el-row>
              </div>
              <div style="width: 99%; border: solid 1px dodgerblue;"></div>
              <div style="text-align: center">
                <el-row>
                  <el-col :span="11"><span style="color: #aaaaaa; font-size: 12px">日常</span></el-col>
                  <el-col :span="13">8909.34</el-col>
                </el-row>
              </div>
            </div>
          </el-col>
          <el-col :span="4-8">
            <div class="back5">
              <div style="text-align: center; color: mediumpurple; padding: 20px;">日均订单量</div>
              <div style="text-align: center">
                <el-row>
                  <el-col :span="11"><span style="color: #aaaaaa; font-size: 12px">节假日</span></el-col>
                  <el-col :span="13">8909</el-col>
                </el-row>
              </div>
              <div style="width: 99%; border: solid 1px mediumpurple;"></div>
              <div style="text-align: center">
                <el-row>
                  <el-col :span="11"><span style="color: #aaaaaa; font-size: 12px">日常</span></el-col>
                  <el-col :span="13">8909.34</el-col>
                </el-row>
              </div>
            </div>
          </el-col>
          <el-col :span="4-8">
            <div class="back5">
              <div style="text-align: center; color: greenyellow; padding: 20px;">日均成交率</div>
              <div style="text-align: center">
                <el-row>
                  <el-col :span="11"><span style="color: #aaaaaa; font-size: 12px">节假日</span></el-col>
                  <el-col :span="13">8909</el-col>
                </el-row>
              </div>
              <div style="width: 99%; border: solid 1px greenyellow;"></div>
              <div style="text-align: center">
                <el-row>
                  <el-col :span="11"><span style="color: #aaaaaa; font-size: 12px">日常</span></el-col>
                  <el-col :span="13">8909.34</el-col>
                </el-row>
              </div>
            </div>
          </el-col>
          <el-col :span="4-8">
            <div class="back5">
              <div style="text-align: center; color: indianred; padding: 20px;">日均销售额</div>
              <div style="text-align: center">
                <el-row>
                  <el-col :span="11"><span style="color: #aaaaaa; font-size: 12px">节假日</span></el-col>
                  <el-col :span="13">8909</el-col>
                </el-row>
              </div>
              <div style="width: 99%; border: solid 1px indianred;"></div>
              <div style="text-align: center">
                <el-row>
                  <el-col :span="11"><span style="color: #aaaaaa; font-size: 12px">日常</span></el-col>
                  <el-col :span="13">8909.34</el-col>
                </el-row>
              </div>
            </div>
          </el-col>
        </el-row>
        <el-row :gutter="5" style="margin-top: 5px;">
          <el-col :span="12">
            <div id="flowBar" style="width: 100%; height: 300px; background-color: #212138; border:none;"></div>
          </el-col>
          <el-col :span="12">
            <div id="moneyBar" style="width: 100%; height: 300px; background-color: #212138; border:none;"></div>
          </el-col>
        </el-row>
        <el-row :gutter="5" style="margin-top: 5px;">
          <el-col :span="12">
            <div id="orderBar" style="width: 100%; height: 300px; background-color: #212138; border:none;"></div>
          </el-col>
          <el-col :span="12">
            <div id="aliasBar" style="width: 100%; height: 300px; background-color: #212138; border:none;"></div>
          </el-col>
        </el-row>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
export default {
  name: 'flow',
  data () {
    return {
      flowTableData: [
        { date: '日常', flow: '255', in: '18.12%', order: '57', success: '22.26%', money: '41.18万' },
        { date: '周末', flow: '255', in: '18.12%', order: '57', success: '22.26%', money: '41.18万' },
        { date: '春节', flow: '255', in: '18.12%', order: '57', success: '22.26%', money: '41.18万' },
        { date: '国庆节', flow: '255', in: '18.12%', order: '57', success: '22.26%', money: '41.18万' },
        { date: '清明节', flow: '255', in: '18.12%', order: '57', success: '22.26%', money: '41.18万' },
        { date: '中秋节', flow: '255', in: '18.12%', order: '57', success: '22.26%', money: '41.18万' },
        { date: '端午节', flow: '255', in: '18.12%', order: '57', success: '22.26%', money: '41.18万' },
        { date: '劳动节', flow: '255', in: '18.12%', order: '57', success: '22.26%', money: '41.18万' },
        { date: '元旦', flow: '255', in: '18.12%', order: '57', success: '22.26%', money: '41.18万' }
      ],
      orderChartData: [
        [20, 40, 60, 30, 79, 88, 120, 56, 112],
        [120, 50, 55, 37, 29, 58, 20, 156, 162],
        [20, 40, 60, 30, 79, 88, 10, 56, 12],
        [10, 50, 55, 37, 29, 58, 20, 16, 62]
      ],

      flowBarData: [
        120, 132, 101, 134, 90, 230, 210
      ],
      moneyBarData: [
        60, 92, 151, 34, 50, 230, 110
      ],
      orderBarData: [
        240, 32, 121, 34, 190, 230, 210
      ],
      aliasBarData: [
        214, 132, 21, 214, 90, 280, 60
      ]
    }
  },
  created () {},
  computed: {
    getIsCollapse () {
      return this.$store.state.app.sidebar.opened
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
    // 修改table tr行的背景色
    tableRowStyle ({ row, rowIndex }) {
      if (rowIndex === 1) {
        return 'background-color:#473C8B;color:#aaaaaa;border:none'
      } else {
        return 'background-color:#212138;color:#aaaaaa;border:none'
      }
    },
    // 修改table header的背景色
    tableHeaderColor ({ row, column, rowIndex, columnIndex }) {
      if (rowIndex === 0) {
        return 'background-color: #212138;color: white;font-weight: 500;border:none;'
      }
    },
    tableCellStyle ({ row, column, rowIndex, columnIndex }) {
      if (rowIndex === 5 && columnIndex === 5) {
        return 'color:green;border:none;'
      } else if (rowIndex === 3 && columnIndex === 4) {
        return 'color:red;border:none;'
      } else {
        return 'border:none;'
      }
    },

    drawOrderChart: function () {
      let width = window.innerWidth || document.documentElement.clientWidth || document.body.clientWidth
      let o = document.getElementById('orderChart')
      if (o) {
        if (width <= 1400) {
          o.style.height = '356px'
        } else {
          o.style.height = '373px'
        }
      }
      let orderChart = this.$echarts.init(document.getElementById('orderChart'))
      let option = {
        title: {
          text: '节假日日均客流量订单',
          textStyle: {
            color: 'white',
            fontSize: 12
          },
          left: 'left',
          top: '0'
        },
        tooltip: {
          trigger: 'axis',
          axisPointer: { // 坐标轴指示器，坐标轴触发有效
            type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
          }
        },
        legend: {
          data: ['日均客流量', '日均订单量', '日均进店率', '日均成交率'],
          textStyle: {
            color: 'white',
            fontSize: 12
          },
          right: 'left',
          top: '25'
        },
        xAxis: [
          {
            type: 'category',
            data: ['日常', '周末', '春节', '国庆节', '清明节', '中秋节', '端午节', '劳动节', '元旦'],
            axisLabel: {
              color: 'white',
              fontSize: 12
            }
          }
        ],
        yAxis: [
          {
            type: 'value',
            min: 0,
            max: 300,
            interval: 50,
            axisLabel: {
              color: 'white',
              fontSize: 12
            }
          },
          {
            type: 'value',
            name: '',
            min: 0,
            max: 100,
            interval: 20,
            axisLabel: {
              formatter: '{value} %',
              color: 'white',
              fontSize: 12
            }
          }
        ],
        series: [
          {
            name: '日均客流量',
            type: 'bar',
            stack: '流量',
            data: this.orderChartData[0]
          },
          {
            name: '日均订单量',
            type: 'bar',
            stack: '流量',
            data: this.orderChartData[1]
          },
          {
            name: '日均进店率',
            type: 'line',
            yAxisIndex: 1,
            data: this.orderChartData[2]
          },
          {
            name: '日均成交率',
            type: 'line',
            yAxisIndex: 1,
            data: this.orderChartData[3]
          }
        ]
      }
      orderChart.setOption(option)
      orderChart.resize()
    },
    drawFlowBar: function () {
      let flowBar = this.$echarts.init(document.getElementById('flowBar'))
      var links = this.flowBarData.map(function (item, i) {
        return {
          source: i,
          target: i + 1
        }
      })
      let option = {
        title: {
          text: '门店日均客流量(国庆节)',
          textStyle: {
            color: 'white',
            fontSize: 12
          },
          left: 'left',
          top: '0'
        },
        tooltip: {
          trigger: 'axis'
        },
        xAxis: {
          type: 'category',
          boundaryGap: false,
          data: ['福州', '南坪', '宁德', '厦门', '潮州', '泉州', '漳州'],
          axisLabel: {
            color: 'white',
            fontSize: 12
          },
          axisLine: {
            show: true
          }
        },
        yAxis: {
          type: 'value',
          show: false,
          axisLabel: {
            color: 'white',
            fontSize: 12
          }
        },
        series: [
          {
            name: '客流量',
            type: 'graph',
            data: this.flowBarData,
            itemStyle: {
              normal: {
                label: {
                  show: true,
                  formatter: '{c}'
                }
              }
            },
            symbolSize: 30,
            links: links,
            coordinateSystem: 'cartesian2d',
            lineStyle: {
              normal: {
                color: 'red'
              }
            }
          }
        ]
      }
      flowBar.setOption(option)
      flowBar.resize()
    },
    drawMoneyBar: function () {
      let moneyBar = this.$echarts.init(document.getElementById('moneyBar'))
      let option = {
        title: {
          text: '门店日均销售额(单位万)(国庆节)',
          textStyle: {
            color: 'white',
            fontSize: 12
          },
          left: 'left',
          top: '0'
        },
        tooltip: {
          trigger: 'axis'
        },
        xAxis: {
          type: 'category',
          boundaryGap: false,
          data: ['福州', '南坪', '宁德', '厦门', '潮州', '泉州', '漳州'],
          axisLabel: {
            color: 'white',
            fontSize: 12
          },
          axisLine: {
            show: true
          }
        },
        yAxis: {
          type: 'value',
          show: false,
          axisLabel: {
            color: 'white',
            fontSize: 12
          }
        },
        series: [
          {
            name: '客流量',
            type: 'bar',
            data: this.moneyBarData,
            label: {
              show: true,
              position: 'top'
            }
          }
        ]
      }
      moneyBar.setOption(option)
      moneyBar.resize()
    },
    drawOrderBar: function () {
      let orderBar = this.$echarts.init(document.getElementById('orderBar'))
      var links = this.orderBarData.map(function (item, i) {
        return {
          source: i,
          target: i + 1
        }
      })
      let option = {
        title: {
          text: '门店日均订单量(国庆节)',
          textStyle: {
            color: 'white',
            fontSize: 12
          },
          left: 'left',
          top: '0'
        },
        tooltip: {
          trigger: 'axis'
        },
        xAxis: {
          type: 'category',
          boundaryGap: false,
          data: ['福州', '南坪', '宁德', '厦门', '潮州', '泉州', '漳州'],
          axisLabel: {
            color: 'white',
            fontSize: 12
          },
          axisLine: {
            show: true
          }
        },
        yAxis: {
          type: 'value',
          show: false,
          axisLabel: {
            color: 'white',
            fontSize: 12
          }
        },
        series: [
          {
            name: '客流量',
            type: 'graph',
            data: this.flowBarData,
            itemStyle: {
              normal: {
                label: {
                  show: true,
                  formatter: '{c}'
                }
              }
            },
            symbolSize: 30,
            links: links,
            coordinateSystem: 'cartesian2d',
            lineStyle: {
              normal: {
                color: 'red'
              }
            }
          }
        ]
      }
      orderBar.setOption(option)
      orderBar.resize()
    },
    drawAliasBar: function () {
      let aliasBar = this.$echarts.init(document.getElementById('aliasBar'))
      let option = {
        title: {
          text: '各时间段客流量分析(国庆节)',
          textStyle: {
            color: 'white',
            fontSize: 12
          },
          left: 'left',
          top: '0'
        },
        tooltip: {
          trigger: 'axis'
        },
        xAxis: {
          type: 'category',
          boundaryGap: false,
          data: ['10-1', '10-2', '10-3', '10-4', '10-5', '10-6', '10-7'],
          axisLabel: {
            color: 'white',
            fontSize: 12
          },
          axisLine: {
            show: true
          }
        },
        yAxis: {
          type: 'value',
          show: false,
          axisLabel: {
            color: 'white',
            fontSize: 12
          }
        },
        series: [
          {
            type: 'line',
            data: this.aliasBarData,
            areaStyle: {},
            label: {
              show: true,
              position: 'top'
            }
          }
        ]
      }
      aliasBar.setOption(option)
      aliasBar.resize()
    },
    temp: function () {
      this.drawOrderChart()
      this.drawFlowBar()
      this.drawMoneyBar()
      this.drawOrderBar()
      this.drawAliasBar()
    }
  },
  mounted () {
    this.temp()
    window.onresize = this.temp
  }
}
</script>

<style scoped>
  .font4 {
    font-size: 40px;
    text-shadow: 0px 0px 5px white, 2px 0px 2px yellow, 2px 2px 3px orange;
    text-align: center;
    padding: 10px;
    font-weight: 900;
    color: black;
  }
  #flow {
    background-color: black;
  }

  .back4 {
    background: #212138;
    color: white;
  }

  .back5 {
    width: 100%;
    height: 140px;
    background: #212138;
    color: white;
    font-size: 20px;
  }

  @media only screen {
    .el-col--4 {
      width: 20%
    }
  }
</style>
