<template>
  <div id="energy" style="overflow: auto">
    <el-row>
      <el-card class="box-card" :body-style="cardBody" style="background-color: #a0cfff">
        <div slot="header" class="clearfix">
          <span>用能统计</span>
          <el-button size="mini" style="float:right; margin-right: 5px;" @click="statisticsAll">确定</el-button>
          <span style="float:right; margin-right: 5px;">能源:
            <el-select v-model="itemValue" placeholder="请选择" size="mini">
              <el-option
                v-for="item in itemOptions"
                :key="item.value"
                :label="item.value"
                :value="item.value">
              </el-option>
            </el-select>
          </span>
          <span style="float:right; margin-right: 5px;">时间:
            <el-select v-model="dateValue" placeholder="请选择" size="mini">
              <el-option
                v-for="item in dateOptions"
                :key="item.value"
                :label="item.value"
                :value="item.value">
              </el-option>
            </el-select>
          </span>
        </div>
        <div id="energyBar" style="width: 100%; height: 270px; background-color: #eeeeee;"></div>
      </el-card>
    </el-row>
    <el-row style="margin-top: 10px;">
      <el-card class="box-card" :body-style="cardBody" style="background-color: #a0cfff">
        <div slot="header" class="clearfix">
          <span>分项用能统计</span>
          <el-button size="mini" style="float:right; margin-right: 5px;" @click="statisticsItem">确定</el-button>
          <span style="float:right; margin-right: 5px;">单位:
            <el-select v-model="unitValue" placeholder="请选择" size="mini" style="width: 120px;">
              <el-option
                v-for="item in unitOptions"
                :key="item.value"
                :label="item.value"
                :value="item.value">
              </el-option>
            </el-select>
          </span>
          <span style="float:right; margin-right: 5px;">楼层:
            <el-select v-model="floorValue" placeholder="请选择" size="mini" style="width: 120px;">
              <el-option
                v-for="item in floorOptions"
                :key="item.value"
                :label="item.value"
                :value="item.value">
              </el-option>
            </el-select>
          </span>
          <span style="float:right; margin-right: 5px;">大楼:
            <el-select v-model="blockValue" placeholder="请选择" size="mini" style="width: 120px;">
              <el-option
                v-for="item in blockOptions"
                :key="item.value"
                :label="item.value"
                :value="item.value">
              </el-option>
            </el-select>
          </span>
          <span style="float:right; margin-right: 5px;">时间:
            <el-select v-model="dateValue2" placeholder="请选择" size="mini" style="width: 120px;">
              <el-option
                v-for="item in dateOptions2"
                :key="item.value"
                :label="item.value"
                :value="item.value">
              </el-option>
            </el-select>
          </span>
        </div>
        <el-row :gutter="5">
          <el-col :span="8"><div id="waterBar" style="width: 100%; height: 260px; background-color: #eeeeee;"></div></el-col>
          <el-col :span="8"><div id="elecBar" style="width: 100%; height: 260px; background-color: #eeeeee;"></div></el-col>
          <el-col :span="8"><div id="coalBar" style="width: 100%; height: 260px; background-color: #eeeeee;"></div></el-col>
        </el-row>
        <el-row :gutter="5">
          <el-col :span="8"><div id="waterPie" style="width: 100%; height: 260px; background-color: #eeeeee;"></div></el-col>
          <el-col :span="8"><div id="elecPie" style="width: 100%; height: 260px; background-color: #eeeeee;"></div></el-col>
          <el-col :span="8"><div id="coalPie" style="width: 100%; height: 260px; background-color: #eeeeee;"></div></el-col>
        </el-row>
      </el-card>
    </el-row>
  </div>
</template>

<script>
export default {
  name: 'energy',
  data () {
    return {
      cardBody: {
        padding: '0px'
      },
      dateValue: '当日',
      dateOptions: [{
        value: '当日'
      }, {
        value: '当月'
      }, {
        value: '当年'
      }],
      itemValue: '所有',
      itemOptions: [{
        value: '所有'
      }, {
        value: '水'
      }, {
        value: '电'
      }, {
        value: '煤'
      }],
      energyBarData: [
        [ 12, 15, 16, 17, 10, 16, 16, 12, 15, 16, 17, 10, 16, 16, 12, 15, 16, 17, 10, 16, 16, 56, 23, 24 ],
        [ 12, 15, 12, 17, 10, 16, 16, 12, 15, 16, 17, 10, 16, 19, 12, 15, 16, 17, 10, 76, 16, 56, 13, 24 ],
        [ 12, 15, 16, 17, 10, 16, 16, 12, 15, 16, 57, 10, 16, 16, 12, 15, 16, 17, 10, 16, 16, 26, 23, 24 ]
      ],

      dateValue2: '当日',
      dateOptions2: [{
        value: '当日'
      }, {
        value: '当月'
      }, {
        value: '当年'
      }],
      blockValue: '1号楼',
      blockOptions: [{
        value: '1号楼'
      }, {
        value: '2号楼'
      }, {
        value: '3号楼'
      }, {
        value: '4号楼'
      }],
      floorValue: '1层',
      floorOptions: [{
        value: '1层'
      }, {
        value: '2层'
      }, {
        value: '3层'
      }, {
        value: '4层'
      }],
      unitValue: '项目部',
      unitOptions: [{
        value: '项目部'
      }, {
        value: '策划部'
      }, {
        value: '销售部'
      }]
    }
  },
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
    },
    item: function (val) {
      this.drawBar()
      this.drawPie()
    }
  },
  methods: {
    drawEnergyBar: function () {
      let energyBarCharts = this.$echarts.init(document.getElementById('energyBar'))
      let option = {
        tooltip: {
          trigger: 'axis',
          axisPointer: { // 坐标轴指示器，坐标轴触发有效
            type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
          }
        },
        legend: {
          data: ['水', '电', '煤']
        },
        grid: {
          left: '3%',
          right: '4%',
          bottom: '3%',
          containLabel: true
        },
        toolbox: {
          show: true,
          orient: 'vertical',
          left: 'right',
          top: 'center',
          feature: {
            mark: {show: true},
            dataView: {show: true, readOnly: false},
            magicType: {show: true, type: ['line', 'bar', 'stack', 'tiled']},
            restore: {show: true},
            saveAsImage: {show: true}
          }
        },
        xAxis: [
          {
            type: 'category',
            data: ['00:00', '01:00', '02:00', '03:00', '04:00', '05:00', '06:00', '07:00',
              '08:00', '09:00', '10:00', '11:00', '12:00', '13:00', '14:00', '15:00',
              '16:00', '17:00', '18:00', '19:00', '20:00', '21:00', '22:00', '23:00']
          }
        ],
        yAxis: [
          {
            type: 'value',
            name: '标准(KJ)',
            axisLabel: {
              show: true
            }
          }
        ],
        series: [
          {
            name: '水',
            type: 'bar',
            stack: 'energy',
            data: this.energyBarData[0]
          },
          {
            name: '电',
            type: 'bar',
            stack: 'energy',
            data: this.energyBarData[1]
          },
          {
            name: '煤',
            type: 'bar',
            stack: 'energy',
            data: this.energyBarData[2]
          }
        ],
        color: [
          '#836FFF', '#7CCD7C', '#CD69C9', '#B3EE3A', '#7D26CD'
        ]
      }
      energyBarCharts.setOption(option)
      energyBarCharts.resize()
    },
    drawWaterBar: function () {
      let waterBar = this.$echarts.init(document.getElementById('waterBar'))
      let option = {
        tooltip: {
          trigger: 'axis',
          axisPointer: { // 坐标轴指示器，坐标轴触发有效
            type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
          }
        },
        legend: {
          data: ['水']
        },
        grid: {
          left: '3%',
          right: '4%',
          bottom: '3%',
          containLabel: true
        },
        xAxis: [
          {
            type: 'category',
            data: ['00:00', '01:00', '02:00', '03:00', '04:00', '05:00', '06:00', '07:00',
              '08:00', '09:00', '10:00', '11:00', '12:00', '13:00', '14:00', '15:00',
              '16:00', '17:00', '18:00', '19:00', '20:00', '21:00', '22:00', '23:00']
          }
        ],
        yAxis: [
          {
            type: 'value',
            name: '标准(KJ)',
            axisLabel: {
              show: true
            }
          }
        ],
        series: [
          {
            name: '水',
            type: 'bar',
            stack: 'energy',
            data: this.energyBarData[0]
          }
        ],
        color: [
          '#836FFF', '#7CCD7C', '#CD69C9', '#B3EE3A', '#7D26CD'
        ]
      }
      waterBar.setOption(option)
      waterBar.resize()
    },
    drawElecBar: function () {
      let elecBar = this.$echarts.init(document.getElementById('elecBar'))
      let option = {
        tooltip: {
          trigger: 'axis',
          axisPointer: { // 坐标轴指示器，坐标轴触发有效
            type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
          }
        },
        legend: {
          data: ['电']
        },
        grid: {
          left: '3%',
          right: '4%',
          bottom: '3%',
          containLabel: true
        },
        xAxis: [
          {
            type: 'category',
            data: ['00:00', '01:00', '02:00', '03:00', '04:00', '05:00', '06:00', '07:00',
              '08:00', '09:00', '10:00', '11:00', '12:00', '13:00', '14:00', '15:00',
              '16:00', '17:00', '18:00', '19:00', '20:00', '21:00', '22:00', '23:00']
          }
        ],
        yAxis: [
          {
            type: 'value',
            name: '标准(KJ)',
            axisLabel: {
              show: true
            }
          }
        ],
        series: [
          {
            name: '电',
            type: 'bar',
            stack: 'energy',
            data: this.energyBarData[1]
          }
        ],
        color: [
          '#7CCD7C', '#CD69C9', '#B3EE3A', '#7D26CD'
        ]
      }
      elecBar.setOption(option)
      elecBar.resize()
    },
    drawCoalBar: function () {
      let coalBar = this.$echarts.init(document.getElementById('coalBar'))
      let option = {
        tooltip: {
          trigger: 'axis',
          axisPointer: { // 坐标轴指示器，坐标轴触发有效
            type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
          }
        },
        legend: {
          data: ['煤']
        },
        grid: {
          left: '3%',
          right: '4%',
          bottom: '3%',
          containLabel: true
        },
        xAxis: [
          {
            type: 'category',
            data: ['00:00', '01:00', '02:00', '03:00', '04:00', '05:00', '06:00', '07:00',
              '08:00', '09:00', '10:00', '11:00', '12:00', '13:00', '14:00', '15:00',
              '16:00', '17:00', '18:00', '19:00', '20:00', '21:00', '22:00', '23:00']
          }
        ],
        yAxis: [
          {
            type: 'value',
            name: '标准(KJ)',
            axisLabel: {
              show: true
            }
          }
        ],
        series: [
          {
            name: '煤',
            type: 'bar',
            stack: 'energy',
            data: this.energyBarData[2]
          }
        ],
        color: [
          '#CD69C9', '#B3EE3A', '#7D26CD'
        ]
      }
      coalBar.setOption(option)
      coalBar.resize()
    },
    drawWaterPie: function () {
      let waterPie = this.$echarts.init(document.getElementById('waterPie'))
      let option = {
        title: {
          text: '水'
        },
        tooltip: {
          trigger: 'item',
          formatter: '{a} <br/>{b} : {c} ({d}%)'
        },
        legend: {
          type: 'scroll',
          orient: 'vertical',
          right: 10,
          top: 20,
          bottom: 20,
          data: ['00:00', '01:00', '02:00', '03:00', '04:00', '05:00', '06:00', '07:00',
            '08:00', '09:00', '10:00', '11:00', '12:00', '13:00', '14:00', '15:00',
            '16:00', '17:00', '18:00', '19:00', '20:00', '21:00', '22:00', '23:00']
        },
        series: [
          {
            name: '水',
            type: 'pie',
            radius: '55%',
            center: ['40%', '50%'],
            data: [
              { name: '00:00', value: this.energyBarData[0][0] },
              { name: '01:00', value: this.energyBarData[0][1] },
              { name: '02:00', value: this.energyBarData[0][2] },
              { name: '03:00', value: this.energyBarData[0][3] },
              { name: '04:00', value: this.energyBarData[0][4] },
              { name: '05:00', value: this.energyBarData[0][5] },
              { name: '06:00', value: this.energyBarData[0][6] },
              { name: '07:00', value: this.energyBarData[0][7] },
              { name: '08:00', value: this.energyBarData[0][8] },
              { name: '09:00', value: this.energyBarData[0][9] },
              { name: '10:00', value: this.energyBarData[0][10] },
              { name: '11:00', value: this.energyBarData[0][11] },
              { name: '12:00', value: this.energyBarData[0][12] },
              { name: '13:00', value: this.energyBarData[0][13] },
              { name: '14:00', value: this.energyBarData[0][14] },
              { name: '15:00', value: this.energyBarData[0][15] },
              { name: '16:00', value: this.energyBarData[0][16] },
              { name: '17:00', value: this.energyBarData[0][17] },
              { name: '18:00', value: this.energyBarData[0][18] },
              { name: '19:00', value: this.energyBarData[0][19] },
              { name: '20:00', value: this.energyBarData[0][20] },
              { name: '21:00', value: this.energyBarData[0][21] },
              { name: '22:00', value: this.energyBarData[0][22] },
              { name: '23:00', value: this.energyBarData[0][23] }
            ],
            itemStyle: {
              emphasis: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
              }
            },
            labelLine: {
              normal: {
                show: true
              }
            }
          }
        ]
      }
      waterPie.setOption(option)
      waterPie.resize()
    },
    drawElecPie: function () {
      let elecPie = this.$echarts.init(document.getElementById('elecPie'))
      let option = {
        title: {
          text: '电'
        },
        tooltip: {
          trigger: 'item',
          formatter: '{a} <br/>{b} : {c} ({d}%)'
        },
        legend: {
          type: 'scroll',
          orient: 'vertical',
          right: 10,
          top: 20,
          bottom: 20,
          data: ['00:00', '01:00', '02:00', '03:00', '04:00', '05:00', '06:00', '07:00',
            '08:00', '09:00', '10:00', '11:00', '12:00', '13:00', '14:00', '15:00',
            '16:00', '17:00', '18:00', '19:00', '20:00', '21:00', '22:00', '23:00']
        },
        series: [
          {
            name: '电',
            type: 'pie',
            radius: '55%',
            center: ['40%', '50%'],
            data: [
              { name: '00:00', value: this.energyBarData[1][0] },
              { name: '01:00', value: this.energyBarData[1][1] },
              { name: '02:00', value: this.energyBarData[1][2] },
              { name: '03:00', value: this.energyBarData[1][3] },
              { name: '04:00', value: this.energyBarData[1][4] },
              { name: '05:00', value: this.energyBarData[1][5] },
              { name: '06:00', value: this.energyBarData[1][6] },
              { name: '07:00', value: this.energyBarData[1][7] },
              { name: '08:00', value: this.energyBarData[1][8] },
              { name: '09:00', value: this.energyBarData[1][9] },
              { name: '10:00', value: this.energyBarData[1][10] },
              { name: '11:00', value: this.energyBarData[1][11] },
              { name: '12:00', value: this.energyBarData[1][12] },
              { name: '13:00', value: this.energyBarData[1][13] },
              { name: '14:00', value: this.energyBarData[1][14] },
              { name: '15:00', value: this.energyBarData[1][15] },
              { name: '16:00', value: this.energyBarData[1][16] },
              { name: '17:00', value: this.energyBarData[1][17] },
              { name: '18:00', value: this.energyBarData[1][18] },
              { name: '19:00', value: this.energyBarData[1][19] },
              { name: '20:00', value: this.energyBarData[1][20] },
              { name: '21:00', value: this.energyBarData[1][21] },
              { name: '22:00', value: this.energyBarData[1][22] },
              { name: '23:00', value: this.energyBarData[1][23] }
            ],
            itemStyle: {
              emphasis: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
              }
            },
            labelLine: {
              normal: {
                show: true
              }
            }
          }
        ]
      }
      elecPie.setOption(option)
      elecPie.resize()
    },
    drawCoalPie: function () {
      let coalPie = this.$echarts.init(document.getElementById('coalPie'))
      let option = {
        title: {
          text: '煤'
        },
        tooltip: {
          trigger: 'item',
          formatter: '{a} <br/>{b} : {c} ({d}%)'
        },
        legend: {
          type: 'scroll',
          orient: 'vertical',
          right: 10,
          top: 20,
          bottom: 20,
          data: ['00:00', '01:00', '02:00', '03:00', '04:00', '05:00', '06:00', '07:00',
            '08:00', '09:00', '10:00', '11:00', '12:00', '13:00', '14:00', '15:00',
            '16:00', '17:00', '18:00', '19:00', '20:00', '21:00', '22:00', '23:00']
        },
        series: [
          {
            name: '煤',
            type: 'pie',
            radius: '55%',
            center: ['40%', '50%'],
            data: [
              { name: '00:00', value: this.energyBarData[2][0] },
              { name: '01:00', value: this.energyBarData[2][1] },
              { name: '02:00', value: this.energyBarData[2][2] },
              { name: '03:00', value: this.energyBarData[2][3] },
              { name: '04:00', value: this.energyBarData[2][4] },
              { name: '05:00', value: this.energyBarData[2][5] },
              { name: '06:00', value: this.energyBarData[2][6] },
              { name: '07:00', value: this.energyBarData[2][7] },
              { name: '08:00', value: this.energyBarData[2][8] },
              { name: '09:00', value: this.energyBarData[2][9] },
              { name: '10:00', value: this.energyBarData[2][10] },
              { name: '11:00', value: this.energyBarData[2][11] },
              { name: '12:00', value: this.energyBarData[2][12] },
              { name: '13:00', value: this.energyBarData[2][13] },
              { name: '14:00', value: this.energyBarData[2][14] },
              { name: '15:00', value: this.energyBarData[2][15] },
              { name: '16:00', value: this.energyBarData[2][16] },
              { name: '17:00', value: this.energyBarData[2][17] },
              { name: '18:00', value: this.energyBarData[2][18] },
              { name: '19:00', value: this.energyBarData[2][19] },
              { name: '20:00', value: this.energyBarData[2][20] },
              { name: '21:00', value: this.energyBarData[2][21] },
              { name: '22:00', value: this.energyBarData[2][22] },
              { name: '23:00', value: this.energyBarData[2][23] }
            ],
            itemStyle: {
              emphasis: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
              }
            },
            labelLine: {
              normal: {
                show: true
              }
            }
          }
        ]
      }
      coalPie.setOption(option)
      coalPie.resize()
    },

    temp: function () {
      this.drawEnergyBar()
      this.drawWaterBar()
      this.drawElecBar()
      this.drawCoalBar()
      this.drawWaterPie()
      this.drawElecPie()
      this.drawCoalPie()
    },
    statisticsAll: function () {
      if (this.dateValue === "当月") {
        this.energyBarData = [
          [ 32, 45, 56, 47, 20, 46, 106, 132, 115, 126, 117, 110, 116, 136, 112, 55, 56, 67, 30, 16, 46, 86, 63, 214 ],
          [ 32, 45, 52, 47, 20, 46, 106, 132, 115, 126, 117, 110, 126, 129, 112, 55, 56, 67, 30, 76, 46, 96, 83, 214 ],
          [ 32, 45, 56, 47, 20, 16, 106, 132, 115, 126, 517, 110, 136, 156, 112, 55, 56, 67, 30, 66, 46, 56, 93, 214 ]
        ]
      } else if(this.dateValue === "当日") {
        this.energyBarData = [
          [ 12, 15, 16, 17, 10, 16, 16, 12, 15, 16, 17, 10, 16, 16, 12, 15, 16, 17, 10, 16, 16, 56, 23, 24 ],
          [ 12, 15, 12, 17, 10, 16, 16, 12, 15, 16, 17, 10, 16, 19, 12, 15, 16, 17, 10, 76, 16, 56, 13, 24 ],
          [ 12, 15, 16, 17, 10, 16, 16, 12, 15, 16, 57, 10, 16, 16, 12, 15, 16, 17, 10, 16, 16, 26, 23, 24 ]
        ]
      } else if(this.dateValue === "当年") {
        this.energyBarData = [
          [ 132, 145, 526, 147, 220, 146, 196, 132, 115, 126, 117, 110, 716, 126, 162, 255, 556, 617, 380, 156, 46, 86, 63, 214 ],
          [ 132, 145, 522, 427, 230, 146, 106, 192, 195, 1126, 517, 810, 126, 129, 112, 55, 56, 67, 30, 76, 46, 966, 863, 214 ],
          [ 132, 145, 56, 427, 260, 166, 106, 132, 115, 126, 517, 110, 136, 156, 112, 55, 56, 67, 30, 66, 46, 156, 923, 214 ]
        ]
      }
      this.drawEnergyBar()
    },
    statisticsItem: function () {
      for (var i=0; i<this.energyBarData.length; i++) {
        for(var j=0; j<this.energyBarData[i].length; j++) {
          this.energyBarData[i][j] += Math.round(Math.random()*100)
        }
      }
      this.drawWaterBar()
      this.drawElecBar()
      this.drawCoalBar()
      this.drawWaterPie()
      this.drawElecPie()
      this.drawCoalPie()
    }
  },
  mounted () {
    this.temp()
    window.onresize = this.temp
  }
}
</script>

<style scoped>
  .el-card__body {
    padding: 0px;
  }
</style>
