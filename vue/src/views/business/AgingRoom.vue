<template>
  <div id="containerAgingRoom" @click="onDocumentMouseClick" style="margin-top: 5px; border: 1px solid #eee; box-shadow: 0px 0px 3px #888;"></div>
</template>

<script>
import * as THREE from 'three'
// import earcut from 'earcut'
// import ThreeBSP from '@/api/ThreeBSP'
import TrackballControls from '@/api/TrackballControls.js'
// import OrbitControls from '@/api/OrbitControls.js'
// import TWEEN from '@/api/Tween.js'
import { CSS3DObject, CSS3DRenderer } from '@/api/ThreeCSS3Render.js'
export default {
  name: 'aging-room',
  props: ['width', 'height'],
  data () {
    return {
      container: null,
      camera: null,
      scene: null,
      renderer: null,
      objects: [],
      group: null,
      table: [
        [
          [{ id: '08098', state: 'green' }, { id: '08000', state: 'yellow' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' },
            { id: '08098', state: 'green' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' },
            { id: '08098', state: 'green' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' },
            { id: '08098', state: 'green' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' },
            { id: '08098', state: 'green' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' },
            { id: '08098', state: 'green' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' },
            { id: '08098', state: 'green' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' },
            { id: '08098', state: 'green' }],
          [{ id: '08098', state: 'green' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' },
            { id: '08098', state: 'green' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' },
            { id: '08098', state: 'green' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' },
            { id: '08098', state: 'green' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' },
            { id: '08098', state: 'green' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' },
            { id: '08098', state: 'green' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' },
            { id: '08098', state: 'green' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' },
            { id: '08098', state: 'green' }],
          [{ id: '08098', state: 'green' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' },
            { id: '08098', state: 'green' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' },
            { id: '08098', state: 'green' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' },
            { id: '08098', state: 'green' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' },
            { id: '08098', state: 'green' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' },
            { id: '08098', state: 'green' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' },
            { id: '08098', state: 'green' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' },
            { id: '08098', state: 'green' }],
          [{ id: '08098', state: 'green' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' },
            { id: '08098', state: 'green' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' },
            { id: '08098', state: 'green' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' },
            { id: '08098', state: 'green' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' },
            { id: '08098', state: 'green' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' },
            { id: '08098', state: 'green' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' },
            { id: '08098', state: 'green' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' },
            { id: '08098', state: 'green' }]
        ],
        [
          [{ id: '08098', state: 'green' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' },
            { id: '08098', state: 'green' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' },
            { id: '08098', state: 'green' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' },
            { id: '08098', state: 'green' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' },
            { id: '08098', state: 'green' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' },
            { id: '08098', state: 'green' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' },
            { id: '08098', state: 'green' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' },
            { id: '08098', state: 'green' }],
          [{ id: '08098', state: 'green' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' },
            { id: '08098', state: 'green' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' },
            { id: '08098', state: 'green' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' },
            { id: '08098', state: 'green' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' },
            { id: '08098', state: 'green' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' },
            { id: '08098', state: 'green' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' },
            { id: '08098', state: 'green' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' },
            { id: '08098', state: 'green' }],
          [{ id: '08098', state: 'green' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' },
            { id: '08098', state: 'green' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' },
            { id: '08098', state: 'green' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' },
            { id: '08098', state: 'green' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' },
            { id: '08098', state: 'green' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' },
            { id: '08098', state: 'green' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' },
            { id: '08098', state: 'green' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' },
            { id: '08098', state: 'green' }],
          [{ id: '08098', state: 'green' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' },
            { id: '08098', state: 'green' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' },
            { id: '08098', state: 'green' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' },
            { id: '08098', state: 'green' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' },
            { id: '08098', state: 'green' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' },
            { id: '08098', state: 'green' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' },
            { id: '08098', state: 'green' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' }, { id: '08098', state: 'red' },
            { id: '08098', state: 'green' }]
        ]
      ]
    }
  },
  methods: {
    init () {
      this.camera = new THREE.PerspectiveCamera(50, this.width / this.height, 1, 10000)
      this.camera.position.z = 2100
      this.scene = new THREE.Scene()

      //
      this.renderer = new CSS3DRenderer()
      this.renderer.setSize(this.width, this.height)
      // this.renderer.setClearColor(0xffffff);
      document.getElementById('containerAgingRoom').appendChild(this.renderer.domElement)
      //

      this.controls = new TrackballControls(this.camera, this.renderer.domElement)
      this.controls.rotateSpeed = 5.0
      this.controls.zoomSpeed = 5
      this.controls.panSpeed = 2
      this.controls.noZoom = false
      this.controls.noPan = false
      this.controls.staticMoving = true
      this.controls.dynamicDampingFactor = 0.3

      this.group = new THREE.Group()
      for (let i = 0; i < this.table.length; i++) {
        for (let j = 0; j < this.table[i].length; j++) {
          for (let k = 0; k < this.table[i][j].length; k++) {
            var element = document.createElement('div')
            element.className = 'element'
            // element.style.backgroundColor = 'rgba(0,127,127,' + ( Math.random() * 0.5 + 0.25 ) + ')';
            element.style.backgroundColor = 'rgba(0,127,127)'
            var number = document.createElement('div')
            number.className = 'number'
            number.textContent = (i + 1) + 'C' + (j + 1) + 'F' + '-' + (k + 1)
            element.appendChild(number)
            var symbol = document.createElement('div')
            symbol.className = 'symbol'
            symbol.textContent = this.table[ i ][ j ][ k ].id
            symbol.style.color = this.table[ i ][ j ][ k ].state
            element.appendChild(symbol)
            // var details = document.createElement( 'div' );
            // details.className = 'details';
            // details.innerHTML = table[ i + 1 ] + '<br>' + table[ i + 2 ];
            // element.appendChild( details );
            var object = new CSS3DObject(element)
            // object.position.x = Math.random() * 4000 - 2000;
            // object.position.y = Math.random() * 4000 - 2000;
            // object.position.z = Math.random() * 4000 - 2000;

            // object.position.y = (i) * 200;
            // object.position.z = (j) * 200;
            // object.position.x = (k) * 200;

            object.position.y = (i * 4 + j) * 200
            object.position.z = 0
            object.position.x = (k) * 200

            // this.scene.add( object );
            this.objects.push(object)
            this.group.add(object)
            this.objects[0].element.children[1].innerHTML = ''
            // console.log(this.objects);

            //
            // var object = new THREE.Object3D();
            // object.position.x = ( table[ i + 3 ] * 140 ) - 1330;
            // object.position.y = - ( table[ i + 4 ] * 180 ) + 990;
            // targets.table.push( object );
          }
        }
      }
      this.group.position.x = -4500
      this.scene.add(this.group)
    },
    animate () {
      requestAnimationFrame(this.animate)
      this.controls.update()
      this.renderer.render(this.scene, this.camera)
    },
    onDocumentMouseClick () {

    }
  },
  mounted () {
    this.init()
    this.animate()
  },
  created () {
    console.log(this.width)
    console.log(this.height)
  }
}
</script>

<style>
  #info {
    position: absolute;
    width: 100%;
    color: #ffffff;
    padding: 5px;
    font-family: Monospace;
    font-size: 13px;
    font-weight: bold;
    text-align: center;
    z-index: 1;
  }
  #menu {
    position: absolute;
    bottom: 20px;
    width: 100%;
    text-align: center;
  }
  .element {
    width: 180px;
    height: 120px;
    box-shadow: 0px 0px 12px rgba(0,255,255,0.5);
    border: 1px solid rgba(127,255,255,0.25);
    text-align: center;
    cursor: default;
  }
  .element:hover {
    box-shadow: 0px 0px 12px rgba(0,255,255,0.75);
    border: 1px solid rgba(127,255,255,0.75);
  }
  .element .number {
    position: absolute;
    top: 20px;
    right: 20px;
    font-size: 12px;
    color: rgba(127,255,255,0.75);
  }
  .element .symbol {
    position: absolute;
    top: 40px;
    left: 0px;
    right: 0px;
    font-size: 60px;
    font-weight: bold;
    color: rgba(255,255,255,0.75);
    text-shadow: 0 0 10px rgba(0,255,255,0.95);
  }
  .element .details {
    position: absolute;
    bottom: 15px;
    left: 0px;
    right: 0px;
    font-size: 12px;
    color: rgba(127,255,255,0.75);
  }
</style>
