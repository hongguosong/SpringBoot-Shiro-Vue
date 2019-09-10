<template>
  <div id="factory">
    <el-row :gutter="0">
      <el-col :span="16">
        <div id="container" @dblclick="onDocumentMouseClick"></div>
      </el-col>
      <el-col :span="8" >
        <el-card shadow="never" :style="{width: chartWidth + 'px', height: chartHeight + 'px'}">
          <div slot="header">
            <span style="fontSize: 20px;">Panel产能</span>
          </div>
          <div id="chartMachineState" :style="{width: chartWidth + 'px', height: chartHeight - 60 + 'px'}"></div>
        </el-card>
        <el-card shadow="never" :style="{width: chartWidth + 'px', height: chartHeight + 'px'}">
          <div slot="header">
            <span style="fontSize: 20px;">当前报警</span>
          </div>
          <el-table
            :data="alarmData"
            style="width: 100%;"
            :height="chartHeight-80"
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
              width="80">
            </el-table-column>
            <el-table-column
              prop="desc"
              label="Description">
            </el-table-column>
            <el-table-column
              prop="start"
              label="Occured"
              width="132">
            </el-table-column>
          </el-table>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import * as THREE from 'three'
import TrackballControls from '@/api/TrackballControls.js'
import OHC from '@/images/OHC.svg'
import ASSY from '@/images/ASSY.svg'
import AUTOTAPE from '@/images/AUTOTAPE.svg'
import ASSYTEST from '@/images/ASSYTEST.svg'
import AGING from '@/images/AGING.svg'
import COOLING from '@/images/COOLING.svg'
import AOI from '@/images/AOI.svg'
import FT from '@/images/FT.svg'

// import fontsThree from '@/fonts/helvetiker_regular.typeface.json'
export default {
  name: 'factory',
  data () {
    return {
      camera: null,
      scene: null,
      renderer: null,
      helper: null,
      materials: [],
      meshs: [],
      geometries: [],
      controls: null,
      qiu: null,
      selectedObject: null,
      selectedColor: null,
      alarm3DObject: [],
      text3D: [
        { x: -16, y: 0, z: 25.85, size: 1, color: '#ff0000', data: { id: 8, alarmCount: 0 } },
        { x: -13, y: 0, z: 26.0, size: 1, color: '#ff0000', data: { id: 9, alarmCount: 0 } },
        { x: -10, y: 0, z: 26.15, size: 1, color: '#ff0000', data: { id: 10, alarmCount: 0 } },
        { x: -7, y: 0, z: 26.3, size: 1, color: '#ff0000', data: { id: 11, alarmCount: 0 } },
        { x: -4, y: 0, z: 26.45, size: 1, color: '#ff0000', data: { id: 12, alarmCount: 0 } },
        { x: -1, y: 0, z: 26.6, size: 1, color: '#ff0000', data: { id: 13, alarmCount: 0 } },
        { x: 2, y: 0, z: 26.75, size: 1, color: '#ff0000', data: { id: 14, alarmCount: 0 } },
        { x: 5, y: 0, z: 26.9, size: 1, color: '#ff0000', data: { id: 15, alarmCount: 0 } },
        { x: 8, y: 0, z: 27.05, size: 1, color: '#ff0000', data: { id: 16, alarmCount: 0 } },
        { x: 11, y: 0, z: 27.2, size: 1, color: '#ff0000', data: { id: 17, alarmCount: 0 } },
        { x: 14, y: 0, z: 27.35, size: 1, color: '#ff0000', data: { id: 18, alarmCount: 0 } },
        { x: 17, y: 0, z: 27.5, size: 1, color: '#ff0000', data: { id: 19, alarmCount: 0 } }
      ],
      width: window.innerWidth * 16 / 24 - 50,
      height: window.innerHeight - 130,
      machineStateChart: null,
      machineStateOption: {
        // title: {
        //   text: 'Panel产能',
        //   left: 40
        // },
        legend: {
          data: ['白班', '夜班', 'Total'],
          textStyle: {
            fontSize: 15
          }
        },
        tooltip: {
          trigger: 'axis',
          axisPointer: {
            type: 'cross',
            label: {
              backgroundColor: '#6a7985'
            }
          },
          textStyle: {
            fontSize: 15
          }
        },
        xAxis: {
          type: 'category',
          data: [ '8', '9', '10', '11', '12', '13', '14', '15',
            '16', '17', '18', '19' ],
          axisLabel: {
            fontSize: 15
          }
        },
        yAxis: {
          type: 'value',
          axisLabel: {
            fontSize: 15
          }
        },
        series: [ {
          name: '白班',
          data: [ 0, 0, 0, 499, 0, 0, 0, 0, 0, 0, 0, 0 ],
          type: 'bar',
          label: {
            show: true,
            rotate: 90,
            fontSize: 15
          }
        }, {
          name: '夜班',
          data: [ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ],
          type: 'bar',
          label: {
            show: true,
            rotate: 90,
            fontSize: 15
          }
        }, {
          name: 'Total',
          data: [ 0, 0, 0, 499, 0, 0, 0, 0, 0, 0, 0, 0 ],
          type: 'line',
          label: {
            show: true,
            fontSize: 15
          }
        } ],
        color: [ '#B5C334', '#3398DB', '#275B7B' ]
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
    chartWidth: function () {
      return (this.width + 50) / 2
    },
    chartHeight: function () {
      return this.height / 2
    },
    ...mapGetters([
      'alarmData',
      'sidebar'
    ])
  },
  methods: {
    onWindowResize () {
      this.width = this.sidebar.opened ? window.innerWidth * 16 / 24 - 50 - 120 : window.innerWidth * 16 / 24 - 50
      this.height = window.innerHeight - 130
      this.camera.aspect = this.width / this.height
      this.camera.updateProjectionMatrix()
      this.renderer.setSize(this.width, this.height)
      this.controls.handleResize()

      var that = this
      setTimeout(function () {
        that.machineStateChart.resize()
      }, 100)
    },
    init: function () {
      let container = document.getElementById('container')
      this.renderer = new THREE.WebGLRenderer({ antialias: true })
      this.renderer.setSize(this.width, this.height)
      this.renderer.setClearColor(0xffffff)
      container.appendChild(this.renderer.domElement)

      // this.camera = new THREE.PerspectiveCamera(55, this.width / this.height, 0.1, 1000)
      this.camera = new THREE.OrthographicCamera(-28, 28, 20, -20, 1, 1000)
      this.camera.position.set(10, 45, 10)
      this.camera.lookAt(new THREE.Vector3(0, 0, 0))

      this.controls = new TrackballControls(this.camera, this.renderer.domElement)
      this.controls.rotateSpeed = 5.0
      this.controls.zoomSpeed = 5
      this.controls.panSpeed = 2
      this.controls.noZoom = false
      this.controls.noPan = false
      this.controls.staticMoving = false
      this.controls.dynamicDampingFactor = 0.3

      this.scene = new THREE.Scene()
      this.scene.add(this.camera)
      this.scene.rotation.x = -Math.PI / 15

      // var helper = new THREE.GridHelper( 70, 50 , 0x0000ff, 0x808080);
      // this.scene.add( helper );

      var geometry = new THREE.PlaneGeometry(50, 60, 32)
      var material = new THREE.MeshBasicMaterial({ color: 0xffffff, side: THREE.DoubleSide })
      var plane = new THREE.Mesh(geometry, material)
      plane.rotation.x = Math.PI / 2
      plane.position.y = -0.5
      plane.position.z = -2
      this.scene.add(plane)

      let pos = -1
      for (let i = -6; i < 6; i++) {
        pos++
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
          // else if(i===3 && j===0){
          //   material = new THREE.MeshLambertMaterial( { color: 0xff0000 } );
          // }
          // else{
          //   material = new THREE.MeshLambertMaterial( { color: 0x666666 } );
          // }

          let mesh = new THREE.Mesh(geometry, material)

          mesh.position.x = i * 3 + 1.5
          mesh.position.z = j * 5 + 2.5 + pos * 0.15
          mesh.data = { id: i + 14, eqpName: eqpName }
          this.geometries.push(geometry)
          this.materials.push(material)
          this.meshs.push(mesh)
          this.scene.add(mesh)

          // if(i===0 && j===0){
          //   var faces = this.geometries[0].faces;
          //   for (let k = 0; k <faces.length; k++) {
          //     faces[k].color.setHex( 0xff0000 );
          //     //faces[k].color.setRGB( Math.random(), Math.random(), Math.random() );
          //   }
          // }

          if (i === 2 && j === 2) {
            this.materials[0].color.setHex(0xffff00) // 黄色
            this.materials[10].color.setHex(0x008000) // 绿色
            this.materials[23].color.setHex(0x0000ff) // 蓝色
            this.materials[55].color.setHex(0xff0000) // 红色
          }
        }
      }

      for (let k = 0; k < this.meshs.length; k++) {
        if (this.meshs[k].data.id === 8 && this.meshs[k].data.eqpName === 'AGING') {
          this.meshs[k].material.color.setHex(0xff0000)
        }
      }

      // geometry = new THREE.SphereBufferGeometry(0.3, 132, 116)
      // material = new THREE.MeshBasicMaterial({ color: 0x222222 })
      // this.qiu = new THREE.Mesh(geometry, material)
      // this.qiu.position.x = 10.5
      // this.qiu.position.y = 0
      // this.qiu.position.z = 20
      // this.scene.add(this.qiu)

      this.addText(this.scene, 'APPAOI', -18.5, 0, -22.5, 0.6, 0x006699)
      this.addText(this.scene, 'PULLTEST', -18.5, 0, -17.5, 0.6, 0x006699)
      this.addText(this.scene, 'FT', -18.5, 0, -12.5, 0.6, 0x006699)
      this.addText(this.scene, 'AOI', -18.5, 0, -7.5, 0.6, 0x006699)
      this.addText(this.scene, 'COOLING', -18.5, 0, -2.5, 0.6, 0x006699)
      this.addText(this.scene, 'AGING', -18.5, 0, 2.5, 0.6, 0x006699)
      this.addText(this.scene, 'ASSYTEST', -18.5, 0, 7.5, 0.6, 0x006699)
      this.addText(this.scene, 'AUTOTYPE', -18.5, 0, 12.5, 0.6, 0x006699)
      this.addText(this.scene, 'ASSY', -18.5, 0, 17.5, 0.6, 0x006699)
      this.addText(this.scene, 'OHC', -18.5, 0, 22.5, 0.6, 0x006699)

      this.addText(this.scene, '8', -16.2, 0, -25.5, 0.6, 0x000000, { id: 8 })
      this.addText(this.scene, '9', -13.2, 0, -25.35, 0.6, 0x000000, { id: 9 })
      this.addText(this.scene, '10', -10.2, 0, -25.2, 0.6, 0x000000, { id: 10 })
      this.addText(this.scene, '11', -7.2, 0, -25.05, 0.6, 0x000000, { id: 11 })
      this.addText(this.scene, '12', -4.2, 0, -24.9, 0.6, 0x000000, { id: 12 })
      this.addText(this.scene, '13', -1.2, 0, -24.75, 0.6, 0x000000, { id: 13 })
      this.addText(this.scene, '14', 1.8, 0, -24.6, 0.6, 0x000000, { id: 14 })
      this.addText(this.scene, '15', 4.8, 0, -24.45, 0.6, 0x000000, { id: 15 })
      this.addText(this.scene, '16', 7.8, 0, -24.3, 0.6, 0x000000, { id: 16 })
      this.addText(this.scene, '17', 10.8, 0, -24.15, 0.6, 0x000000, { id: 17 })
      this.addText(this.scene, '18', 13.8, 0, -24.0, 0.6, 0x000000, { id: 18 })
      this.addText(this.scene, '19', 16.8, 0, -23.85, 0.6, 0x000000, { id: 19 })

      this.addColorFlag('RUN', '#008000', 19.8, 0, 21)
      this.addColorFlag('DOWN', '#ff0000', 19.8, 0, 8)
      this.addColorFlag('IDLE', '#ffff00', 19.8, 0, -5)
      this.addColorFlag('PM', '#0000ff', 19.8, 0, -18)

      // this.add3DText(this.scene, -16, 0, 27, 1, '#ff0000', { id: 8, alarmCount: 67 })
      // this.add3DText(this.scene, -13, 0, 27, 1, '#ff0000', { id: 9, alarmCount: 67 })
      // this.add3DText(this.scene, -10, 0, 27, 1, '#ff0000', { id: 10, alarmCount: 14 })
      // this.add3DText(this.scene, -7, 0, 27, 1, '#ff0000', { id: 11, alarmCount: 72 })
      // this.add3DText(this.scene, -4, 0, 27, 1, '#ff0000', { id: 12, alarmCount: 67 })
      // this.add3DText(this.scene, -1, 0, 27, 1, '#ff0000', { id: 13, alarmCount: 57 })
      // this.add3DText(this.scene, 2, 0, 27, 1, '#ff0000', { id: 14, alarmCount: 37 })
      // this.add3DText(this.scene, 5, 0, 27, 1, '#ff0000', { id: 15, alarmCount: 44 })
      // this.add3DText(this.scene, 8, 0, 27, 1, '#ff0000', { id: 16, alarmCount: 17 })
      // this.add3DText(this.scene, 11, 0, 27, 1, '#ff0000', { id: 17, alarmCount: 22 })
      // this.add3DText(this.scene, 14, 0, 27, 1, '#ff0000', { id: 18, alarmCount: 67 })
      // this.add3DText(this.scene, 17, 0, 27, 1, '#ff0000', { id: 19, alarmCount: 67 })

      for (var k = 8; k < 20; k++) {
        var lineAlarmNo = this.getLineAlarmNo(k)
        if (lineAlarmNo > 0) {
          for (var i = 0; i < this.text3D.length; i++) {
            if (this.text3D[i].data.id === k) {
              this.text3D[i].data.alarmCount = lineAlarmNo
              this.add3DText(this.scene,
                this.text3D[i].x,
                this.text3D[i].y,
                this.text3D[i].z,
                this.text3D[i].size,
                this.text3D[i].color,
                { id: this.text3D[i].data.id, alarmCount: this.text3D[i].data.alarmCount })
            }
          }
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
    addText: function (scene, message, x, y, z, size, color, data) {
      // 添加文字
      var loader = new THREE.FontLoader()
      loader.load('../static/fonts/helvetiker_regular.typeface.json', function (font) {
        var xMid
        var text
        // var matDark = new THREE.LineBasicMaterial({
        //   color: color,
        //   side: THREE.DoubleSide
        // })
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
      //   // make line shape ( N.B. edge view remains visible )
      //   var holeShapes = []
      //   for (var i = 0; i < shapes.length; i++) {
      //     var shape = shapes[ i ]
      //     if (shape.holes && shape.holes.length > 0) {
      //       for (var j = 0; j < shape.holes.length; j++) {
      //         var hole = shape.holes[ j ]
      //         holeShapes.push(hole)
      //       }
      //     }
      //   }
      //   shapes.push.apply(shapes, holeShapes)
      //   var lineText = new THREE.Object3D()
      //   for (var i = 0; i < shapes.length; i++) {
      //     var shape = shapes[ i ]
      //     var points = shape.getPoints()
      //     var geometry = new THREE.BufferGeometry().setFromPoints(points)
      //     geometry.translate(xMid, 0, 0)
      //     var lineMesh = new THREE.Line(geometry, matDark)
      //     lineText.add(lineMesh)
      //   }
      //   scene.add(lineText)
      })
    },
    addColorFlag: function (text, color, x, y, z) {
      var materials = [
        new THREE.MeshBasicMaterial({ color: 'white' }), // right
        new THREE.MeshBasicMaterial({ color: 'white' }), // left
        new THREE.MeshBasicMaterial({ map: new THREE.CanvasTexture(this.getTextCanvas(text, color)) }), // top
        new THREE.MeshBasicMaterial({ color: 'white' }), // bottom
        new THREE.MeshBasicMaterial({ color: 'whitw' }), // back
        new THREE.MeshBasicMaterial({ color: 'white' }) // front
      ]
      var panel = new THREE.Mesh(new THREE.CubeGeometry(13, 0, 2), materials)
      panel.position.x = x
      panel.position.y = y
      panel.position.z = z
      panel.rotation.y = Math.PI / 2
      this.scene.add(panel)
    },
    add3DText: function (scene, x, y, z, size, color, data) {
      // 添加文字
      var loader = new THREE.FontLoader()
      var that = this
      loader.load('../static/fonts/helvetiker_regular.typeface.json', function (font) {
        // var xMid
        var text
        var matLite = new THREE.MeshBasicMaterial({
          color: color,
          transparent: true,
          opacity: 0.4,
          side: THREE.DoubleSide
        })
        var geometry = new THREE.TextGeometry(data.alarmCount.toString(), {
          font: font,
          size: size,
          height: 0.4
          // curveSegments: 0.1,
          // bevelEnabled: true,
          // bevelThickness: 0.1,
          // bevelSize: 0.1,
          // bevelSegments: 0.1
        })
        // geometry.computeBoundingBox()
        // xMid = -0.5 * (geometry.boundingBox.max.x - geometry.boundingBox.min.x)
        // geometry.translate(xMid, 0, 0)

        text = new THREE.Mesh(geometry, matLite)
        text.position.z = z
        text.position.y = y
        text.position.x = x
        text.rotation.x = -Math.PI / 2
        text.rotation.z = Math.PI / 2
        text.data = data
        scene.add(text)
        that.alarm3DObject.push(text)
      })
    },
    addAlarmCount: function () {

    },
    getTextCanvas (text, color) {
      var width = 1664
      var height = 256
      var canvas = document.createElement('canvas')
      canvas.width = width
      canvas.height = height
      var ctx = canvas.getContext('2d')
      ctx.fillStyle = color
      ctx.fillRect(0, 0, width, height)
      ctx.font = 150 + 'px " bold'
      ctx.fillStyle = '#000000'
      ctx.textAlign = 'center'
      ctx.textBaseline = 'middle'
      ctx.fillText(text, width / 2, height / 2)
      return canvas
    },
    onDocumentMouseClick: function (event) {
      // // event.preventDefault();
      // if (this.selectedObject) {
      //   // this.selectedObject.material.color.set( '#'+this.selectedColor );
      //   this.selectedObject.material = new THREE.MeshLambertMaterial({
      //     color: '#' + this.selectedColor,
      //     side: THREE.DoubleSide
      //   })
      //   this.selectedObject = null
      // }
      var vector = new THREE.Vector3()// 三维坐标对象
      vector.set(
        (event.layerX / this.width) * 2 - 1,
        -(event.layerY / this.height) * 2 + 1,
        0.5
      )
      var raycaster = new THREE.Raycaster()
      raycaster.setFromCamera(vector, this.camera)
      // var intersects = []; //楼层中的元素

      var intersects = raycaster.intersectObjects(this.scene.children)
      if (intersects.length > 0) {
        this.selectedObject = intersects[0].object
        if (this.selectedObject.data !== undefined) {
          // alert('Pallet ID: ' + this.selectedObject.data.id)
          localStorage.setItem('lineNo', this.selectedObject.data.id)
          this.$router.push({ path: `/system/Line` })
        } else {
          // this.selectedColor = this.selectedObject.material.color.getHexString()
          // // this.selectedObject.material.color.set( '#f00' );
          // this.selectedObject.material = new THREE.MeshLambertMaterial({ color: '#f86332', side: THREE.DoubleSide })
        } // 选中的样式
      }

      this.renderer.render(this.scene, this.camera)
    },
    animate: function () {
      requestAnimationFrame(this.animate)
      // if (this.qiu.position.z >= 2.5 && this.qiu.position.x === 10.5) {
      //   this.qiu.position.z -= 0.1
      // }
      // if (this.qiu.position.z < 2.5 && this.qiu.position.x >= 1.5) {
      //   this.qiu.position.x -= 0.1
      // }
      // if (this.qiu.position.x < 1.5 && this.qiu.position.z >= -22.5) {
      //   this.qiu.position.z -= 0.1
      // }
      // if (this.qiu.position.z.toFixed(2) === -22.5) {
      //   this.qiu.position.x = 10.5
      //   this.qiu.position.y = 0
      //   this.qiu.position.z = 20
      // }
      this.controls.update()
      this.renderer.render(this.scene, this.camera)
    },
    initChartMachineState () {
      this.machineStateChart = this.$echarts.init(document.getElementById('chartMachineState'))
      // 使用制定的配置项和数据显示图表
      this.machineStateChart.setOption(this.machineStateOption, true)
    },
    getLineAlarmNo: function (id) {
      var count = 0
      for (var i = 0; i < this.alarmData.length; i++) {
        if (this.alarmData[i].id === id) {
          count++
        }
      }
      return count
    }
  },
  mounted () {
    this.init()
    this.animate()
    this.initChartMachineState()
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

          for (var i = 0; i < that.text3D.length; i++) {
            if (that.text3D[i].data.id === data.id) {
              that.text3D[i].data.alarmCount = data.list.length
              for (var j = 0; j < that.alarm3DObject.length; j++) {
                if (that.alarm3DObject[j].data.id === data.id) {
                  that.scene.remove(that.alarm3DObject[j])
                }
              }
              if (data.list.length > 0) {
                that.add3DText(that.scene,
                  that.text3D[i].x,
                  that.text3D[i].y,
                  that.text3D[i].z,
                  that.text3D[i].size,
                  that.text3D[i].color,
                  { id: that.text3D[i].data.id, alarmCount: that.text3D[i].data.alarmCount })
              }
            }
          }
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

<style scoped>
.el-card__header {
  padding: 15px;
}
</style>
