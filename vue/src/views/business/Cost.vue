<template>
  <div id="cost">
    <el-card class="box-card" :body-style="cardBody" style="background-color: #a0cfff">
      <div slot="header" class="clearfix">
        <span>费用统计</span>
        <el-button size="mini" style="float:right; margin-right: 5px;">确定</el-button>
        <span style="float:right; margin-right: 5px;">选择日期:
          <el-date-picker
            v-model="dateValue"
            :type="itemValue"
            size="mini"
            placeholder="选择日期"
            style="width: 125px;">
          </el-date-picker>
        </span>
        <span style="float:right; margin-right: 5px;">选择类型:
          <el-select v-model="itemValue" placeholder="请选择" size="mini" style="width: 100px;">
            <el-option
              v-for="item in itemOptions"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
        </span>
      </div>
      <el-row :gutter="2">
        <el-col :span="12">
          <div id="lastBar" style="width: 100%; height: 628px; background-color: #eeeeee;"></div>
        </el-col>
        <el-col :span="12">
          <el-row><div id="classifyBar" style="width: 100%; height: 287px; background-color: #eeeeee;"></div></el-row>
          <el-row style="background-color: #eeeeee;margin-top: 5px">
            <!--<el-row>-->
              <!--<el-button-group>-->
                <!--<el-button size="mini" style="width: 60px;" autofocus>电</el-button>-->
                <!--<el-button size="mini" style="width: 60px;">水</el-button>-->
                <!--<el-button size="mini" style="width: 60px;">冷</el-button>-->
                <!--<el-button size="mini" style="width: 60px;">热</el-button>-->
                <!--<el-button size="mini" style="width: 60px;">油</el-button>-->
                <!--<el-button size="mini" style="width: 60px;">蒸汽</el-button>-->
                <!--<el-button size="mini" style="width: 60px;">燃气</el-button>-->
              <!--</el-button-group>-->
            <!--</el-row>-->
            <!--<el-row>-->
              <!--<div id="itemPie" style="width: 100%; height: 280px; background-color: #eeeeee;"></div>-->
            <!--</el-row>-->
            <el-tabs type="card">
              <el-tab-pane label="电">
                <div id="itemPie" style="width: 100%; height: 280px; background-color: #eeeeee;"></div>
              </el-tab-pane>
              <el-tab-pane label="水">水</el-tab-pane>
              <el-tab-pane label="冷">冷</el-tab-pane>
              <el-tab-pane label="热">热</el-tab-pane>
              <el-tab-pane label="油">油</el-tab-pane>
              <el-tab-pane label="蒸汽">蒸汽</el-tab-pane>
              <el-tab-pane label="燃气">燃气</el-tab-pane>
            </el-tabs>
          </el-row>
        </el-col>
      </el-row>
    </el-card>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
export default {
  name: 'cost',
  data () {
    return {
      lastBar: null,
      classifyBar: null,
      itemPie: null,
      cardBody: {
        padding: '0px'
      },
      itemValue: 'month',
      itemOptions: [
        {label: '按年查询', value: 'year'},
        {label: '按月查询', value: 'month'},
        {label: '按日查询', value: 'date'}
      ],
      dateValue: ''
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
    }
  },
  methods: {
    drawLastBar: function () {
      let option = {
        title: {
          text: '最近6个月费用',
          x: 'center',
          textStyle: {
            fontSize: '15'
          }
        },
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
        xAxis: [
          {
            type: 'category',
            data: ['5月', '6月', '7月', '8月', '9月', '10月']
          }
        ],
        yAxis: [
          {
            type: 'value',
            name: '千元',
            axisLabel: {
              show: true
            }
          }
        ],
        series: [
          {
            type: 'bar',
            data: [12, 67, 90, 56, 88, 145]
          }
        ],
        color: [
          '#836FFF', '#7CCD7C', '#CD69C9', '#B3EE3A', '#7D26CD'
        ]
      }
      this.lastBar.setOption(option)
      this.lastBar.resize()
    },
    drawClassifyBar: function () {
      let option = {
        title: {
          text: '分类费用',
          x: 'center',
          textStyle: {
            fontSize: '15'
          }
        },
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
        xAxis: [
          {
            type: 'category',
            data: ['电', '水', '冷量', '热量', '蒸汽', '油', '燃气']
          }
        ],
        yAxis: [
          {
            type: 'value',
            name: '千元',
            axisLabel: {
              show: true
            }
          }
        ],
        series: [
          {
            type: 'bar',
            data: [112, 67, 178, 90, 56, 88, 145]
          }
        ],
        color: [
          '#CD69C9', '#B3EE3A', '#7D26CD'
        ]
      }
      this.classifyBar.setOption(option)
      this.classifyBar.resize()
    },
    drawItemPie: function () {
      let option = {
        title: {
          text: '分项费用',
          x: 'center',
          textStyle: {
            fontSize: '15'
          }
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
          data: ['电梯', '动力', '空调', '照明', '其他']
        },
        series: [
          {
            name: '电',
            type: 'pie',
            radius: '55%',
            center: ['40%', '50%'],
            data: [
              { name: '电梯', value: '12' },
              { name: '动力', value: '56' },
              { name: '空调', value: '89' },
              { name: '照明', value: '44' },
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
      this.itemPie.setOption(option)
      this.itemPie.resize()
    },
    temp: function () {
      this.drawLastBar()
      this.drawClassifyBar()
      var that = this
      setTimeout(
        function () {
          that.drawItemPie()
        }, 100)
    }
  },
  mounted () {
    this.lastBar = this.$echarts.init(document.getElementById('lastBar'))
    this.classifyBar = this.$echarts.init(document.getElementById('classifyBar'))
    this.itemPie = this.$echarts.init(document.getElementById('itemPie'))
    this.temp()
    window.onresize = this.temp
  }
}
</script>

<style>
  .el-tabs--border-card > .el-tabs__content {
    padding: 0px;
  }
  .el-tabs--card > .el-tabs__header .el-tabs__item.is-active {
    border-bottom-color: lightblue;
  }
</style>
