<template>
  <div id="line">
    <el-card shadow="never">
      <div slot="header">
        <span>LINE STATE</span>
        <span style="fontSize: 15px; border-radius: 3px; background-color: green">RUN</span>
        <span style="fontSize: 15px; border-radius: 3px; background-color: red">DOWN</span>
        <span style="fontSize: 15px; border-radius: 3px; background-color: yellow">IDLE</span>
        <span style="fontSize: 15px; border-radius: 3px; background-color: blue; color: white">PM</span>
        <div style="display: inline-block; float: right">
          <span>select line: </span>
          <el-select v-model="lineNo" placeholder="请选择线体编号" size="mini" @change="onLineChange">
            <el-option
              v-for="item in agingLines"
              :key="item.id"
              :label="item.id"
              :value="item.id">
            </el-option>
          </el-select>
        </div>
      </div>
      <div id="container"></div>
    </el-card>
    <el-row>
      <el-col :span="18">
        <el-card shadow="never">
          <div slot="header">
            <span>Eqp State</span>
          </div>
          <div id="eqpStateChart" style="height: 250px; width: 100%"></div>
        </el-card>
      </el-col>
      <el-col :span="6">
        <el-card shadow="never">
          <div slot="header">
            <span>Yield</span>
          </div>
          <div id="yieldChart" style="height: 250px; width: 100%"></div>
        </el-card>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="18">
        <el-card shadow="never">
          <div slot="header">
            <span>Tact Time</span>
          </div>
          <div id="tactTimeChart" style="height: 250px; width: 100%"></div>
        </el-card>
      </el-col>
      <el-col :span="6">
        <el-card shadow="never">
          <div slot="header">
            <span>Capacity</span>
          </div>
          <div id="capacityChart" style="height: 250px; width: 100%"></div>
        </el-card>
      </el-col>
    </el-row>
    <el-dialog title="Current AlarmList" :visible="alarmDialogVisible" @close="close">
      <el-table
          :data="alarmData"
          style="width: 100%;"
          height="250"
          stripe
          border
          :row-class-name="tableRowClassName"
          size="mini">
          <el-table-column
            prop="id"
            label="LineId"
            width="60">
          </el-table-column>
          <el-table-column
            prop="code"
            label="Code"
            width="60">
          </el-table-column>
          <el-table-column
            prop="unit"
            label="Unit"
            width="100">
          </el-table-column>
          <el-table-column
            prop="desc"
            label="Description">
          </el-table-column>
          <el-table-column
            prop="start"> <!-- eslint-disable-next-line -->
            <template slot="header" slot-scope="scope">
              <i class="el-icon-time"></i>
              <span>Occured</span>
            </template>
          </el-table-column>
        </el-table>
    </el-dialog>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import * as THREE from 'three'
import OHC from '@/images/OHC.svg'
import ASSY from '@/images/ASSY.svg'
import AUTOTAPE from '@/images/AUTOTAPE.svg'
import ASSYTEST from '@/images/ASSYTEST.svg'
import AGING from '@/images/AGING.svg'
import COOLING from '@/images/COOLING.svg'
import AOI from '@/images/AOI.svg'
import FT from '@/images/FT.svg'
var colorStyle = {
  runColor: '#68BC31',
  idleColor: 'orange',
  alarmColor: 'purple',
  downColor: 'red',
  pmColor: 'blue',
  stopColor: '#686f7d'
}
export default {
  data () {
    return {
      lineNo: 8,
      agingLines: [],
      camera: null,
      scene: null,
      renderer: null,
      meshs: [],
      group: null,
      width: window.innerWidth - 50,
      height: 100,
      eqpStateChart: null,
      capacityChart: null,
      tactTimeChart: null,
      yieldChart: null,
      optionCapacityChart: {
        // title: {
        //   text: 'Capacity'
        // },
        grid: {
          left: '50',
          top: '20'
        },
        tooltip: {
          trigger: 'axis',
          axisPointer: {
            type: 'cross',
            label: {
              backgroundColor: '#6a7985'
            }
          },
          formatter: '{c} (p)'
        },
        xAxis: {
          type: 'category',
          data: [ 'day', 'week', 'mouth' ]
        },
        yAxis: {
          type: 'value'
        },
        series: [ {
          data: [ 10, 20, 30 ],
          type: 'bar',
          name: 'Capacity',
          label: {
            show: true
          }
        } ],
        color: colorStyle.runColor
      },
      optionYieldChart: {
        // title: {
        //   text: 'Yield'
        // },
        grid: {
          left: '50',
          top: '20'
        },
        tooltip: {
          trigger: 'axis',
          axisPointer: {
            type: 'cross',
            label: {
              backgroundColor: '#6a7985'
            }
          },
          formatter: '{c} (p)'
        },
        xAxis: {
          type: 'category',
          data: [ 'CLASS A', 'CLASS B' ]
        },
        yAxis: {
          type: 'value'
        },
        series: [ {
          data: [ 0, 0 ],
          type: 'bar',
          name: 'Yield',
          label: {
            show: true
          },
          itemStyle: {
            normal: {
              color: function (params) {
                var colorList = [
                  '#B5C334', '#9BCA63',
                  '#C1232B', '#FCCE10', '#E87C25', '#27727B',
                  '#FE8463', '#FAD860', '#F3A43B', '#60C0DD',
                  '#D7504B', '#C6E579', '#F4E001', '#F0805A', '#26C0C0'
                ]
                return colorList[params.dataIndex]
              }
            }
          }
        } ]
      },
      optionEqpStateChart: {
        // title: {
        //   text: 'Equipment Status'
        // },
        grid: {
          left: '50',
          top: '25',
          right: '50'
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
        legend: {
          // orient: 'vertical',
          // x: 'right',
          // top: '30px',
          data: ['RUN-TIME', 'DOWN-TIME', 'IDLE-TIME', 'PM-TIME', 'OP-TIME']
        },
        xAxis: [ {
          type: 'category',
          data: [ 'EntireLine', 'Fusing', 'IT01', 'IT02', 'Aging Chamber', 'LI01', 'FI01', 'FI02',
            'FI03', 'FI04', 'FI05', 'FI06', 'FI07', 'FI08', 'FI09', 'FI10', 'OHC', 'AUTOTAPE', 'FIAOI', 'PULLTAPE', 'APPAOI', 'ASSY']
        } ],
        yAxis: [ {
          type: 'value'
        } ],
        series: [
          {
            name: 'RUN-TIME',
            type: 'bar',
            stack: 'total',
            label: {
              normal: {
                show: true,
                position: 'inside'
              }
            },
            areaStyle: {
              normal: {}
            },
            data: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
          },
          {
            name: 'DOWN-TIME',
            type: 'bar',
            stack: 'total',
            label: {
              normal: {
                show: true,
                position: 'inside'
              }
            },
            areaStyle: {
              normal: {}
            },
            data: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
          },
          {
            name: 'IDLE-TIME',
            type: 'bar',
            stack: 'total',
            label: {
              normal: {
                show: true,
                position: 'inside'
              }
            },
            areaStyle: {
              normal: {}
            },
            data: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
          },
          {
            name: 'PM-TIME',
            type: 'bar',
            stack: 'total',
            label: {
              normal: {
                show: true,
                position: 'inside'
              }
            },
            areaStyle: {
              normal: {}
            },
            data: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
          },
          {
            name: 'OP-TIME',
            type: 'bar',
            stack: 'total',
            label: {
              normal: {
                show: true,
                position: 'inside'
              }
            },
            areaStyle: {
              normal: {}
            },
            data: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
          }],
        color: [colorStyle.runColor, colorStyle.downColor, colorStyle.idleColor,
          colorStyle.pmColor, colorStyle.alarmColor]
      },
      optionTacttimeChart: {
        // title: {
        //   text: 'Tact Time'
        // },
        grid: {
          left: '50',
          top: '20',
          right: '30'
        },
        tooltip: {
          trigger: 'axis',
          axisPointer: {
            type: 'cross',
            label: {
              backgroundColor: '#6a7985'
            }
          },
          formatter: '{c}s'
        },
        xAxis: {
          type: 'category',
          data: [ 'Line In', 'Fusing', 'IT01', 'IT02', 'Aging In', 'Aging Out', 'AOI01', 'FI01', 'FI02', 'FI03', 'FI04',
            'FI05', 'FI06', 'FI07', 'FI08', 'FI09', 'FI10', 'Line Out', 'OHC', 'AUTOTAPE', 'FIAOI', 'PULLTAPE', 'APPAOI', 'ASSY']
        },
        yAxis: {
          type: 'value'
        },
        series: [ {
          data: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
          type: 'bar',
          name: 'Capacity',
          label: {
            show: true,
            position: 'top'
          }
        } ],
        color: '#27727B'
      }
    }
  },
  watch: {
    sidebar: {
      handler (newValue, oldValue) {
        this.onWindowResize()
      },
      deep: true
    }
  },
  computed: {
    ...mapGetters([
      'alarmDialogVisible',
      'alarmData',
      'sidebar'
    ])
  },
  methods: {
    tableRowClassName ({ row, rowIndex }) {
      if (rowIndex % 2 === 1) {
        return 'success-row'
      } else {
        return 'warning-row'
      }
    },
    onWindowResize () {
      this.width = this.sidebar.opened ? window.innerWidth - 50 - 180 : window.innerWidth - 50
      this.height = 100
      this.camera.aspect = this.width / this.height
      this.camera.updateProjectionMatrix()
      this.renderer.setSize(this.width, this.height)

      var that = this
      setTimeout(function () {
        that.capacityChart.resize()
        that.yieldChart.resize()
        that.tactTimeChart.resize()
        that.eqpStateChart.resize()
      }, 200)
    },
    init: function () {
      let container = document.getElementById('container')
      this.renderer = new THREE.WebGLRenderer({ antialias: true })
      this.renderer.setSize(this.width, this.height)
      this.renderer.setClearColor(0xffffff)
      container.appendChild(this.renderer.domElement)

      // this.camera = new THREE.PerspectiveCamera(55, this.width / this.height, 0.1, 1000)
      this.camera = new THREE.OrthographicCamera(-24, 24, 1, -1, 1, 1000)
      this.camera.position.set(45, 45, 0)
      this.camera.lookAt(new THREE.Vector3(0, 0, 0))

      this.scene = new THREE.Scene()
      this.scene.add(this.camera)
      // this.scene.rotateZ = 0.3

      this.group = new THREE.Group()

      for (let j = -5; j < 5; j++) {
        let geometry = new THREE.BoxGeometry(1, 1, 4)
        let material
        let eqpName
        if (j === -5) {
          eqpName = 'APPAOI'
          let texture = new THREE.TextureLoader().load(AOI)
          material = new THREE.MeshLambertMaterial({ map: texture })
        } else if (j === -4) {
          eqpName = 'PULLTEST'
          let texture = new THREE.TextureLoader().load(OHC)
          material = new THREE.MeshLambertMaterial({ map: texture })
        } else if (j === -3) {
          eqpName = 'FT'
          let texture = new THREE.TextureLoader().load(FT)
          material = new THREE.MeshLambertMaterial({ map: texture })
        } else if (j === -2) {
          eqpName = 'AOI'
          let texture = new THREE.TextureLoader().load(AOI)
          material = new THREE.MeshLambertMaterial({ map: texture })
        } else if (j === -1) {
          eqpName = 'COOLING'
          let texture = new THREE.TextureLoader().load(COOLING)
          material = new THREE.MeshLambertMaterial({ map: texture })
        } else if (j === 0) {
          eqpName = 'AGING'
          let texture = new THREE.TextureLoader().load(AGING)
          material = new THREE.MeshLambertMaterial({ map: texture })
        } else if (j === 1) {
          eqpName = 'ASSYTEST'
          let texture = new THREE.TextureLoader().load(ASSYTEST)
          material = new THREE.MeshLambertMaterial({ map: texture })
        } else if (j === 2) {
          eqpName = 'AUTOTAPE'
          let texture = new THREE.TextureLoader().load(AUTOTAPE)
          material = new THREE.MeshLambertMaterial({ map: texture })
        } else if (j === 3) {
          eqpName = 'ASSY'
          let texture = new THREE.TextureLoader().load(ASSY)
          material = new THREE.MeshLambertMaterial({ map: texture })
        } else if (j === 4) {
          eqpName = 'OHC'
          let texture = new THREE.TextureLoader().load(OHC)
          material = new THREE.MeshLambertMaterial({ map: texture })
        }

        let mesh = new THREE.Mesh(geometry, material)

        mesh.position.z = j * 4.1 + 2.1
        mesh.data = { eqpName: eqpName }
        this.meshs.push(mesh)
        this.scene.add(mesh)
      }

      this.addText(this.scene, 'APPAOI', 2, 2.3, -18.5, 0.4, 0x000000)
      this.addText(this.scene, 'PULLTEST', 2, 2.3, -14.5, 0.4, 0x000000)
      this.addText(this.scene, 'FT', 2, 2.3, -10, 0.4, 0x000000)
      this.addText(this.scene, 'AOI', 2, 2.3, -6, 0.4, 0x000000)
      this.addText(this.scene, 'COOLING', 2, 2.3, -2, 0.4, 0x000000)
      this.addText(this.scene, 'AGING', 2, 2.3, 2.2, 0.4, 0x000000)
      this.addText(this.scene, 'ASSYTEST', 2, 2.3, 6.5, 0.4, 0x000000)
      this.addText(this.scene, 'AUTOTYPE', 2, 2.3, 10.5, 0.4, 0x000000)
      this.addText(this.scene, 'ASSY', 2, 2.3, 14.5, 0.4, 0x000000)
      this.addText(this.scene, 'OHC', 2, 2.3, 18.5, 0.4, 0x000000)

      this.addText(this.scene, this.lineNo.toString(), 2, 1.7, 21.5, 0.4, 0x000000, { lineNo: this.lineNo })

      for (let k = 0; k < this.meshs.length; k++) {
        if (this.meshs[k].data.eqpName === 'AGING') {
          this.meshs[k].material.color.setHex(0xff0000)
        } else if (this.meshs[k].data.eqpName === 'OHC') {
          this.meshs[k].material.color.setHex(0x00ff00)
        } else if (this.meshs[k].data.eqpName === 'ASSY') {
          this.meshs[k].material.color.setHex(0x0000ff)
        } else {
          this.meshs[k].material.color.setHex(0xffff00)
        }
      }

      // Lights
      this.scene.add(new THREE.AmbientLight(0xffffff))
      var directionalLight = new THREE.DirectionalLight(0xffffff, 0.125)
      directionalLight.position.x = Math.random() * 10 - 5
      directionalLight.position.y = Math.random() * 10 - 5
      directionalLight.position.z = Math.random() * 10 - 5
      directionalLight.position.normalize()
      this.scene.add(directionalLight)
      this.pointLight = new THREE.PointLight(0xffffff, 1)
      this.pointLight.position.y = 40
      this.scene.add(this.pointLight)

      window.addEventListener('resize', this.onWindowResize, false)
    },
    animate: function () {
      requestAnimationFrame(this.animate)
      this.renderer.render(this.scene, this.camera)
    },
    addText: function (scene, message, x, y, z, size, color, data) {
      // 添加文字
      var loader = new THREE.FontLoader()
      loader.load('../static/fonts/helvetiker_regular.typeface.json', function (font) {
        var xMid
        var text
        var matLite = new THREE.MeshBasicMaterial({
          color: color,
          transparent: true,
          opacity: 0.4,
          side: THREE.DoubleSide
        })
        var shapes = font.generateShapes(message, size)
        var geometry = new THREE.ShapeBufferGeometry(shapes)
        geometry.computeBoundingBox()
        xMid = -0.5 * (geometry.boundingBox.max.x - geometry.boundingBox.min.x)
        geometry.translate(xMid, 0, 0)
        // make shape ( N.B. edge view not visible )
        text = new THREE.Mesh(geometry, matLite)
        text.position.z = z
        text.position.y = y
        text.position.x = x
        text.rotation.x = -Math.PI / 2
        text.rotation.z = Math.PI / 2
        text.data = data
        scene.add(text)
      })
    },
    initLines: function () {
      this.api({
        url: '/AgMonitor/AgLines?id=' + 0,
        method: 'get'
      }).then(data => {
        this.agingLines = data.list
      })
    },
    onLineChange: function () {
      for (var i = 0; i < this.scene.children.length; i++) {
        if (this.scene.children[i].data !== undefined) {
          if (this.scene.children[i].data.lineNo !== undefined) {
            this.scene.remove(this.scene.children[i])
            this.addText(this.scene, this.lineNo.toString(), 2, 1.7, 21.5, 0.4, 0x000000, { lineNo: this.lineNo })
          }
        }
      }
    },
    close: function () {
      console.log('close')
      this.$store.commit('SETALARMDIALOGVISIBLE', false)
    },
    initEqpStateChart: function () {
      // 初始化echarts实例
      this.eqpStateChart = this.$echarts.init(document.getElementById('eqpStateChart'))
      // 使用制定的配置项和数据显示图表
      this.eqpStateChart.setOption(this.optionEqpStateChart)
    },
    initCapacityChart: function () {
      this.capacityChart = this.$echarts.init(document.getElementById('capacityChart'))
      this.capacityChart.setOption(this.optionCapacityChart)
    },
    initTactTimeChart: function () {
      this.tactTimeChart = this.$echarts.init(document.getElementById('tactTimeChart'))
      this.tactTimeChart.setOption(this.optionTacttimeChart)
    },
    initYieldChart: function () {
      this.yieldChart = this.$echarts.init(document.getElementById('yieldChart'))
      this.yieldChart.setOption(this.optionYieldChart)
    },
    getDayCapacity: function () {
      var that = this
      var startDt = new Date()
      var endDt = new Date()
      var hour = startDt.getHours()
      if ((hour < 6)) {
        startDt = new Date(startDt.getTime() - 24 * 60 * 60 * 1000)
        endDt = startDt
      }
      this.optionCapacityChart.xAxis.data[0] = 'day\n' + startDt.format('yyyy-MM-dd')
      this.capacityChart.setOption(this.optionCapacityChart)
      this.api({
        method: 'post',
        url: '/AgHistory/getWorkGroup?lineId={0}&startDate={1}&endDate={2}'.strFormat(this.lineNo, startDt.getTime(), endDt.getTime()),
        contentType: 'application/json; charset=utf-8'
      }).then(data => {
        if (data != null && data.length > 0) {
          var count = 0
          for (var x in data) {
            if (data[x].lineId === that.lineNo) {
              that.optionYieldChart.series[0].data[0] = data[x].groupACount
              that.optionYieldChart.series[0].data[1] = data[x].groupBCount
              count += data[x].groupACount + data[x].groupBCount
            }
          }
          that.optionCapacityChart.series[0].data[0] = count
          that.yieldChart.setOption(that.optionYieldChart)
          that.capacityChart.setOption(that.optionCapacityChart)
        }
      }).catch(data => {
        console.log(data)
        that.$message({
          message: data.response.data.returnMsg,
          type: 'error'
        })
      })
    },
    getWeekCapacit: function () {
      var that = this
      var endDt = new Date()
      var thisyear = endDt.getFullYear()
      var thismonth = endDt.getMonth()
      var nowDayOfWeek = endDt.getDay()
      var nowDay = endDt.getDate()
      var startDt = new Date(thisyear, thismonth, nowDay - nowDayOfWeek)
      this.optionCapacityChart.xAxis.data[1] = 'week\n' + startDt.format('yyyy-MM-dd') + '\n~\n' + endDt.format('yyyy-MM-dd')
      this.capacityChart.setOption(this.optionCapacityChart)
      this.api({
        method: 'post',
        url: '/AgHistory/getWorkGroup?lineId={0}&startDate={1}&endDate={2}'.strFormat(this.lineNo, startDt.getTime(), endDt.getTime()),
        contentType: 'application/json; charset=utf-8'
      }).then(data => {
        if (data != null && data.length > 0) {
          var count = 0
          for (var i = 0; i < data.length; i++) {
            if (data[i].lineId === that.lineNo) {
              count += data[i].groupACount + data[i].groupBCount + data[i].groupCCount
            }
          }
          that.optionCapacityChart.series[0].data[1] = count
          that.capacityChart.setOption(that.optionCapacityChart)
        }
      }).catch(data => {
        console.log(data)
        that.$message({
          message: data.response.data.returnMsg,
          type: 'error'
        })
      })
    },
    getMonthCapacity: function () {
      var that = this
      var endDt = new Date()
      var thisyear = endDt.getFullYear()
      var thismonth = endDt.getMonth()
      var startDt = new Date(thisyear, thismonth, 1)
      this.optionCapacityChart.xAxis.data[2] = 'mouth\n' + startDt.format('yyyy-MM-dd') + '\n~\n' + endDt.format('yyyy-MM-dd')
      this.capacityChart.setOption(this.optionCapacityChart)
      this.api({
        method: 'post',
        url: '/AgHistory/getWorkGroup?lineId={0}&startDate={1}&endDate={2}'.strFormat(this.lineNo, startDt.getTime(), endDt.getTime()),
        contentType: 'application/json; charset=utf-8'
      }).then(data => {
        if (data != null && data.length > 0) {
          var count = 0
          for (var i = 0; i < data.length; i++) {
            if (data[i].lineId === that.lineNo) {
              count += data[i].groupACount + data[i].groupBCount + data[i].groupCCount
            }
          }
          that.optionCapacityChart.series[0].data[2] = count
          that.capacityChart.setOption(that.optionCapacityChart)
        }
      }).catch(data => {
        console.log(data)
        that.$message({
          message: data.response.data.returnMsg,
          type: 'error'
        })
      })
    }
  },
  mounted () {
    var lineNo = localStorage.getItem('lineNo')
    if (lineNo === null || lineNo === undefined) {
      localStorage.setItem('lineNo', 8)
      lineNo = 8
    }
    this.lineNo = lineNo
    this.initLines()
    this.init()
    this.animate()

    this.initEqpStateChart()
    this.initCapacityChart()
    this.initTactTimeChart()
    this.initYieldChart()

    this.getDayCapacity()
    this.getWeekCapacit()
    this.getMonthCapacity()

    this.onWindowResize()

    var that = this
    this.websocket.setConnectCallback(function (client) {
      client.subscribe('/topic/alarmCount', function (data) {
        let temp = JSON.parse(data.body)
        that.api({
          url: that.$serverURL + 'AgAlarm/getCurrentAlarm?id=' + temp.id,
          method: 'get'
        }).then(data => {
          console.log(data)
          console.log(temp)
          data.id = temp.id
          that.$store.commit('SETALARMDATA', data)
          if (data.list.length > 0) {
            that.$store.commit('SETALARMDIALOGVISIBLE', true)
          }
        }).catch(data => {
          console.log(data)
          that.$message({
            message: data.response.data.returnMsg,
            type: 'error'
          })
        })
      })
    })
    this.websocket.setCloseCallback(function (client) {
      client.unsubscribe('/topic/alarmCount')
    })
    this.websocket.initWebSocket()
  },
  destroyed () {
    this.websocket.close()
  }
}
</script>

<style>
#line .el-card__header {
  padding: 18px 20px;
}

#line .el-table .warning-row {
  background: oldlace;
}

#line .el-table .success-row {
  background: #f0f9eb;
}

#line .el-dialog__header {
    background-color: #E04141;
}
#line .el-dialog__body {
  padding: 0;
}
</style>
