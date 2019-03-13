<template>
  <div id="energy">
    <el-row>
      <el-card class="box-card" :body-style="cardBody" style="background-color: #a0cfff">
        <div slot="header" class="clearfix">
          <span>用能统计</span>
          <el-button size="mini" @click="energySearch" style="float:right; margin-right: 5px;">确定</el-button>
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
        <div id="energyBar" style="width: 100%; height: 300px; background-color: #eeeeee;"></div>
      </el-card>
    </el-row>
    <el-row style="margin-top: 10px;">
      <el-card class="box-card" :body-style="cardBody" style="background-color: #a0cfff">
        <div slot="header" class="clearfix">
          <span>分项用能统计</span>
          <el-button size="mini" style="width: 60px;" autofocus @click="setItem('水')">水</el-button>
          <el-button size="mini" style="width: 60px; margin-left: 20px;" @click="setItem('电')">电</el-button>
          <el-button size="mini" style="width: 60px;" @click="setItem('煤')">煤</el-button>
          <!--<el-button size="mini" style="width: 60px;">冷</el-button>-->
          <!--<el-button size="mini" style="width: 60px;">热</el-button>-->
          <!--<el-button size="mini" style="width: 60px;">油</el-button>-->
          <!--<el-button size="mini" style="width: 60px;">蒸汽</el-button>-->
          <!--<el-button size="mini" style="width: 60px;">燃气</el-button>-->
        </div>
        <el-row :gutter="5">
          <el-col :span="12"><div id="elecBar" style="width: 100%; height: 300px; background-color: #eeeeee;"></div></el-col>
          <el-col :span="12"><div id="elecPie" style="width: 100%; height: 300px; background-color: #eeeeee;"></div></el-col>
        </el-row>
      </el-card>
    </el-row>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
export default {
  name: 'energy',
  data () {
    return {
      energyBar: null,
      bar: null,
      pie: null,
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
      item: '水'
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
    setItem: function (item) {
      this.item = item
    },
    energySearch: function () {
      this.drawEnergyBar(this.dateValue)
    },
    drawEnergyBar: function (dateValue) {
      let option
      if (dateValue === '当日') {
        option = {
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
      } else if (dateValue === '当月') {
        option = {
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
              data: ['1', '2', '3', '4', '5', '6', '7', '8',
                '9', '10', '11', '12', '13', '14', '15', '16',
                '17', '18', '19', '20', '21', '22', '23', '24',
                '25', '26', '27', '28', '29', '30']
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
              data: [12, 45, 78, 90, 34, 67, 89, 120, 89, 66,
                12, 45, 78, 90, 34, 67, 89, 120, 89, 66,
                12, 45, 78, 90, 34, 67, 89, 120, 89, 66]
            },
            {
              name: '电',
              type: 'bar',
              stack: 'energy',
              data: [12, 45, 78, 190, 34, 67, 89, 120, 89, 66,
                12, 45, 78, 90, 134, 67, 89, 120, 89, 66,
                12, 45, 78, 90, 34, 67, 89, 120, 89, 66]
            },
            {
              name: '煤',
              type: 'bar',
              stack: 'energy',
              data: [12, 45, 78, 90, 34, 67, 89, 12, 89, 66,
                12, 45, 8, 30, 34, 77, 89, 20, 89, 66,
                12, 4, 28, 90, 34, 67, 89, 120, 89, 66]
            }
          ],
          color: [
            '#836FFF', '#7CCD7C', '#CD69C9', '#B3EE3A', '#7D26CD'
          ]
        }
      } else if (dateValue === '当年') {
        option = {
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
              data: ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月',
                '9月', '10月', '11月', '12月']
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
              data: [12, 45, 78, 90, 34, 67, 89, 120, 89, 66, 12, 45]
            },
            {
              name: '电',
              type: 'bar',
              stack: 'energy',
              data: [12, 45, 78, 190, 34, 67, 89, 120, 89, 66, 12, 45]
            },
            {
              name: '煤',
              type: 'bar',
              stack: 'energy',
              data: [12, 45, 78, 90, 34, 67, 89, 12, 89, 66, 112, 45]
            }
          ],
          color: [
            '#836FFF', '#7CCD7C', '#CD69C9', '#B3EE3A', '#7D26CD'
          ]
        }
      }
      this.energyBar.setOption(option)
      this.energyBar.resize()
    },
    drawBar: function () {
      let option
      if (this.item === '水') {
        option = {
          title: {
            text: '水费分项用能统计',
            left: 'center'
          },
          tooltip: {
            trigger: 'axis',
            axisPointer: { // 坐标轴指示器，坐标轴触发有效
              type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
            }
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
              data: ['厕所', '机房', '水暖', '净水', '其他']
            }
          ],
          yAxis: [
            {
              type: 'value',
              name: '立方米',
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
              data: [12, 56, 89, 44, 90]
            }
          ],
          color: [
            '#7CCD7C', '#CD69C9', '#B3EE3A', '#7D26CD'
          ]
        }
      } else if (this.item === '电') {
        option = {
          title: {
            text: '电费分项用能统计',
            left: 'center'
          },
          tooltip: {
            trigger: 'axis',
            axisPointer: { // 坐标轴指示器，坐标轴触发有效
              type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
            }
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
              data: ['电梯', '空调', '照明', '动力', '其他']
            }
          ],
          yAxis: [
            {
              type: 'value',
              name: '千瓦时',
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
              data: [112, 56, 89, 144, 90]
            }
          ],
          color: [
            '#7CCD7C', '#CD69C9', '#B3EE3A', '#7D26CD'
          ]
        }
      } else if (this.item === '煤') {
        option = {
          title: {
            text: '煤气分项用能统计',
            left: 'center'
          },
          tooltip: {
            trigger: 'axis',
            axisPointer: { // 坐标轴指示器，坐标轴触发有效
              type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
            }
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
              data: ['暖气', '热水器', '厨房', '其他']
            }
          ],
          yAxis: [
            {
              type: 'value',
              name: '立方米',
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
              data: [156, 89, 144, 190]
            }
          ],
          color: [
            '#7CCD7C', '#CD69C9', '#B3EE3A', '#7D26CD'
          ]
        }
      }
      this.bar.setOption(option)
      this.bar.resize()
    },
    drawPie: function () {
      let option
      if (this.item === '水') {
        option = {
          title: {
            text: '能耗百分比'
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
            data: ['厕所', '机房', '水暖', '净水', '其他']
          },
          series: [
            {
              name: '水',
              type: 'pie',
              radius: '55%',
              center: ['40%', '50%'],
              data: [
                { name: '厕所', value: '12' },
                { name: '机房', value: '56' },
                { name: '水暖', value: '89' },
                { name: '净水', value: '44' },
                { name: '其他', value: '90' }
              ],
              itemStyle: {
                emphasis: {
                  shadowBlur: 10,
                  shadowOffsetX: 0,
                  shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
              },
              label: {
                formatter: '{b} ({d}%)'
              },
              labelLine: {
                normal: {
                  show: true
                }
              }
            }
          ]
        }
      } else if (this.item === '电') {
        option = {
          title: {
            text: '能耗百分比'
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
            data: ['电梯', '空调', '照明', '动力', '其他']
          },
          series: [
            {
              name: '电',
              type: 'pie',
              radius: '55%',
              center: ['40%', '50%'],
              data: [
                { name: '电梯', value: '112' },
                { name: '空调', value: '56' },
                { name: '照明', value: '89' },
                { name: '动力', value: '144' },
                { name: '其他', value: '90' }
              ],
              itemStyle: {
                emphasis: {
                  shadowBlur: 10,
                  shadowOffsetX: 0,
                  shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
              },
              label: {
                formatter: '{b} ({d}%)'
              },
              labelLine: {
                normal: {
                  show: true
                }
              }
            }
          ]
        }
      } else if (this.item === '煤') {
        option = {
          title: {
            text: '能耗百分比'
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
            data: ['暖气', '热水器', '厨房', '其他']
          },
          series: [
            {
              name: '煤',
              type: 'pie',
              radius: '55%',
              center: ['40%', '50%'],
              data: [
                { name: '暖气', value: '156' },
                { name: '热水器', value: '89' },
                { name: '厨房', value: '144' },
                { name: '其他', value: '190' }
              ],
              itemStyle: {
                emphasis: {
                  shadowBlur: 10,
                  shadowOffsetX: 0,
                  shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
              },
              label: {
                formatter: '{b} ({d}%)'
              },
              labelLine: {
                normal: {
                  show: true
                }
              }
            }
          ]
        }
      }
      this.pie.setOption(option)
      this.pie.resize()
    },

    temp: function () {
      this.drawEnergyBar(this.dateValue)
      this.drawBar()
      this.drawPie()
    }
  },
  mounted () {
    this.energyBar = this.$echarts.init(document.getElementById('energyBar'))
    this.bar = this.$echarts.init(document.getElementById('elecBar'))
    this.pie = this.$echarts.init(document.getElementById('elecPie'))
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
