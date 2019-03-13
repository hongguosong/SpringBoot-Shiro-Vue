<template>
  <div>
    <el-button @click="add(palletId, value)" size="mini">Add</el-button>
    <el-input size="mini" id="pallet-id" v-model="palletId" style="display: inline-block; width: 80px;" autofocus="true" @click.native.prevent="onFocus()"></el-input>
    <el-select v-model="value" placeholder="请选择" size="mini">
      <el-option
        v-for="item in options"
        :key="item.value"
        :label="item.label"
        :value="item.value">
      </el-option>
    </el-select>
    <el-button @click="start" size="mini">{{startLabel}}</el-button>
    <div id="container" @click="onDocumentMouseClick" style="margin-top: 5px;"></div>
  </div>
</template>

<script>
  import * as THREE from 'three'
  import earcut from 'earcut'
  import ThreeBSP from '@/api/ThreeBSP'
  import TrackballControls from '@/api/TrackballControls.js'
  import OrbitControls from '@/api/OrbitControls.js'
  export default {
    name: "floor",
    data () {
      return {
        startLabel: 'stop',
        stop: false,
        options: [{
          value: '0',
          label: '8线'
        }, {
          value: '1',
          label: '9线'
        }],
        value: '0',
        palletId: '',

        container: null,
        camera: null,
        scene: null,
        renderer: null,
        helper: null,
        materials: [],
        meshs: [],
        geometries: [],
        controls: null,
        floorGroup: [],
        width: window.innerWidth - 50,
        height: window.innerHeight - 130,
        selectedObject: null,
        selectedColor: null,
        //panel: [],

      }
    },
    methods: {
      onFocus: function () {
        var pFocus;
        pFocus = document.getElementById("pallet-id");
        pFocus.focus();
        //pFocus.select();
      },
      start: function () {
        if (this.stop) {
          this.stop = false
          this.startLabel = 'stop'
        } else {
          this.stop = true
          this.startLabel = 'start'
        }
      },
      init: function () {
        this.scene = new THREE.Scene();

        this.container = document.getElementById('container');
        this.renderer = new THREE.WebGLRenderer({antialias: true});
        this.renderer.setSize(this.width, this.height);
        this.renderer.setClearColor(0x000000);
        this.container.appendChild(this.renderer.domElement);

        this.camera = new THREE.PerspectiveCamera(45, this.width / this.height, 1, 1000);
        //this.camera = new THREE.OrthographicCamera( this.width / - 2, this.width / 2, this.height / 2, this.height / - 2, 1, 1000 );
        this.camera.position.set(0, 550, 500);
        //this.camera.lookAt(new THREE.Vector3(0, 0, 0));
        this.camera.lookAt(this.scene.position);
        this.scene.add(this.camera);

        this.controls = new TrackballControls(this.camera, this.renderer.domElement);
        this.controls.rotateSpeed = 5.0;
        this.controls.zoomSpeed = 5;
        this.controls.panSpeed = 2;
        this.controls.noZoom = false;
        this.controls.noPan = false;
        this.controls.staticMoving = true;
        this.controls.dynamicDampingFactor = 0.3;


        // // controls
        // this.controls = new OrbitControls( this.camera, this.renderer.domElement );
        // //controls.addEventListener( 'change', render ); // call this only in static scenes (i.e., if there is no animation loop)
        // // this.controls.enableDamping = true; // an animation loop is required when either damping or auto-rotation are enabled
        // // this.controls.dampingFactor = 0.25;
        // // this.controls.screenSpacePanning = false;
        // // this.controls.minDistance = 0;
        // // this.controls.maxDistance = 600;
        // // this.controls.maxPolarAngle = Math.PI / 1;



        var group1 = new THREE.Group();
        group1.panel = [];
        group1.position.x = -600;
        this.floorGroup.push(group1);
        //this.scene.add(this.floorGroup);

        // var helper = new THREE.GridHelper( 2000, 2000 , 0x0000ff, 0x808080);
        // this.scene.add( helper );

        var LOADTR = [
          [0, 0, 0],
          [0, 0, 30],
          [10, 0, 30],
          [10, 0, 0]
        ];
        var MODE_CHANGE = [
          [10, 0, 0],
          [10, 0, 10],
          [30, 0, 10],
          [30, 0, 0]
        ];

        var RETURN_LF = [
          [30, 0, 0],
          [30, 0, 10],
          [40, 0, 10],
          [40, 0, 0]
        ];
        var LOAD = [
          [10, 0, 30],
          [30, 0, 30],
          [30, 0, 20],
          [10, 0, 20]
        ];
        var WIRE = [
          [30, 0, 30],
          [50, 0, 30],
          [50, 0, 20],
          [30, 0, 20]
        ];

        var FUSING_TR = [
          [50, 0, 30],
          [70, 0, 30],
          [70, 0, 20],
          [50, 0, 20]
        ];

        var FUSING = [
          [70, 0, 20],
          [70, 0, 60],
          [80, 0, 60],
          [80, 0, 20]
        ];

        var AT01 = [
          [80, 0, 30],
          [80, 0, 60],
          [90, 0, 60],
          [90, 0, 30]
        ];

        var AT02 = [
          [90, 0, 30],
          [90, 0, 60],
          [100, 0, 60],
          [100, 0, 30]
        ];

        var REP_BUF = [
          [100, 0, 0],
          [100, 0, 50],
          [110, 0, 50],
          [110, 0, 0]
        ];

        var REP = [
          [110, 0, 0],
          [110, 0, 50],
          [120, 0, 50],
          [120, 0, 0]
        ];

        var IN_BRIDGE_LF = [
          [120, 0, 40],
          [120, 0, 50],
          [130, 0, 50],
          [130, 0, 40]
        ];

        var GATE_WAY = [
          [130, 30, 40],
          [130, 30, 50],
          [140, 30, 50],
          [140, 30, 40]
        ];

        var TURN = [
          [140, 30, 40],
          [140, 30, 50],
          [150, 30, 50],
          [150, 30, 40]
        ];

        var AG_IN_LF = [
          [150, 0, 30],
          [150, 0, 50],
          [160, 0, 50],
          [160, 0, 30]
        ];

        var AG_RM_1_1 = [
          [160, 0, 40],
          [160, 0, 50],
          [590, 0, 50],
          [590, 0, 40]
        ];

        var AG_RM_1_2 = [
          [160, 10, 40],
          [160, 10, 50],
          [590, 10, 50],
          [590, 10, 40]
        ];

        var AG_RM_1_3 = [
          [160, 20, 40],
          [160, 20, 50],
          [590, 20, 50],
          [590, 20, 40]
        ];

        var AG_RM_1_4 = [
          [160, 30, 40],
          [160, 30, 50],
          [590, 30, 50],
          [590, 30, 40]
        ];

        var AG_RM_2_1 = [
          [160, 0, 30],
          [160, 0, 40],
          [590, 0, 40],
          [590, 0, 30]
        ];

        var AG_RM_2_2 = [
          [160, 10, 30],
          [160, 10, 40],
          [590, 10, 40],
          [590, 10, 30]
        ];

        var AG_RM_2_3 = [
          [160, 20, 30],
          [160, 20, 40],
          [590, 20, 40],
          [590, 20, 30]
        ];

        var AG_RM_2_4 = [
          [160, 30, 30],
          [160, 30, 40],
          [590, 30, 40],
          [590, 30, 30]
        ];

        var AG_OUT_LF = [
          [590, 0, 30],
          [590, 0, 50],
          [600, 0, 50],
          [600, 0, 30]
        ];

        var INSP = [
          [600, 0, 30],
          [600, 0, 40],
          [610, 0, 40],
          [610, 0, 50],
          [620, 0, 50],
          [620, 0, 40],
          [630, 0, 40],
          [630, 0, 30]
        ];

        var CL_1 = [
          [630, 0, 30],
          [630, 0, 40],
          [890, 0, 40],
          [890, 0, 30]
        ];

        var CL_2 = [
          [630, 0, 40],
          [630, 0, 50],
          [890, 0, 50],
          [890, 0, 40]
        ];

        var CL_OUT = [
          [890, 0, 30],
          [890, 0, 40],
          [900, 0, 40],
          [900, 0, 30]
        ];

        var CL_OUT_LF = [
          [900, 0, 30],
          [900, 0, 40],
          [910, 0, 40],
          [910, 0, 30]
        ];

        var CL_OUT_RT = [
          [910, 30, 0],
          [910, 30, 40],
          [930, 30, 40],
          [930, 30, 30],
          [920, 30, 30],
          [920, 30, 0]
        ];

        var AG_CL_RT = [
          [40, 30, 0],
          [40, 30, 10],
          [910, 30, 10],
          [910, 30, 0]
        ];

        var FT_IN_LF = [
          [930, 0, 30],
          [930, 0, 40],
          [940, 0, 40],
          [940, 0, 30]
        ];

        var FI_IN_TR = [
          [940, 0, 30],
          [940, 0, 50],
          [950, 0, 50],
          [950, 0, 30]
        ];

        var FI_1 = [
          [950, 0, 20],
          [950, 0, 50],
          [960, 0, 50],
          [960, 0, 20]
        ];

        var FI_2 = [
          [960, 0, 20],
          [960, 0, 50],
          [970, 0, 50],
          [970, 0, 20]
        ];

        var FI_TR_1 = [
          [970, 0, 30],
          [970, 0, 40],
          [990, 0, 40],
          [990, 0, 30]
        ];

        var FI_TR_2 = [
          [970, 0, 40],
          [970, 0, 50],
          [990, 0, 50],
          [990, 0, 40]
        ];

        var FI_3 = [
          [990, 0, 20],
          [990, 0, 50],
          [1000, 0, 50],
          [1000, 0, 20]
        ];

        var FI_4 = [
          [1000, 0, 20],
          [1000, 0, 50],
          [1010, 0, 50],
          [1010, 0, 20]
        ];

        var FT_IN_TR = [
          [1010, 0, 10],
          [1010, 0, 40],
          [1020, 0, 40],
          [1020, 0, 10]
        ];

        var FT_1 = [
          [1020, 0, 10],
          [1020, 0, 40],
          [1030, 0, 40],
          [1030, 0, 10]
        ];

        var FT_2 = [
          [1030, 0, 10],
          [1030, 0, 40],
          [1040, 0, 40],
          [1040, 0, 10]
        ];

        var FT_3 = [
          [1040, 0, 10],
          [1040, 0, 40],
          [1050, 0, 40],
          [1050, 0, 10]
        ];

        var FT_4 = [
          [1050, 0, 10],
          [1050, 0, 40],
          [1060, 0, 40],
          [1060, 0, 10]
        ];

        var FT_5 = [
          [1060, 0, 0],
          [1060, 0, 30],
          [1070, 0, 30],
          [1070, 0, 0]
        ];

        var FT_6 = [
          [1070, 0, 0],
          [1070, 0, 30],
          [1080, 0, 30],
          [1080, 0, 0]
        ];

        var FT_7 = [
          [1080, 0, 0],
          [1080, 0, 30],
          [1090, 0, 30],
          [1090, 0, 0]
        ];

        var FT_8 = [
          [1090, 0, 0],
          [1090, 0, 30],
          [1100, 0, 30],
          [1100, 0, 0]
        ];

        var LOAD_OUT = [
          [1100, 0, 20],
          [1100, 0, 30],
          [1130, 0, 30],
          [1130, 0, 20]
        ];

        var LOAD_OUT_LF = [
          [1130, 0, 20],
          [1130, 0, 30],
          [1140, 0, 30],
          [1140, 0, 20]
        ];

        var FT_RT = [
          [920, 30, 20],
          [920, 30, 30],
          [1130, 30, 30],
          [1130, 30, 20]
        ];

        var drawFactory = function (that, group) {
          that.floorGeometry(group, LOADTR, 2);
          that.floorGeometry(group, MODE_CHANGE, 2);
          that.floorGeometry(group, RETURN_LF, 32);
          that.floorGeometry(group, LOAD, 2);
          that.floorGeometry(group, WIRE, 2);
          that.floorGeometry(group, FUSING_TR, 2);
          that.floorGeometry(group, FUSING, 2);
          that.floorGeometry(group, AT01, 2);
          that.borderXdraw(group,[
            [80, 0, 30],
            [80, 0, 40],
            [90, 0, 40],
            [90, 0, 30]
          ], 2)
          that.borderXdraw(group,[
            [80, 0, 40],
            [80, 0, 50],
            [90, 0, 50],
            [90, 0, 40]
          ], 2)
          that.borderXdraw(group,[
            [80, 0, 50],
            [80, 0, 60],
            [90, 0, 60],
            [90, 0, 50]
          ], 2)
          that.floorGeometry(group, AT02, 2);
          that.borderXdraw(group,[
            [90, 0, 30],
            [90, 0, 40],
            [100, 0, 40],
            [100, 0, 30]
          ], 2)
          that.borderXdraw(group,[
            [90, 0, 40],
            [90, 0, 50],
            [100, 0, 50],
            [100, 0, 40]
          ], 2)
          that.borderXdraw(group,[
            [90, 0, 50],
            [90, 0, 60],
            [100, 0, 60],
            [100, 0, 50]
          ], 2)
          that.floorGeometry(group, REP_BUF, 2);
          that.borderXdraw(group,[
            [100, 0, 0],
            [100, 0, 10],
            [110, 0, 10],
            [110, 0, 0]
          ], 2)
          that.borderXdraw(group,[
            [100, 0, 40],
            [100, 0, 50],
            [110, 0, 50],
            [110, 0, 40]
          ], 2)
          that.floorGeometry(group, REP, 2);
          that.borderXdraw(group,[
            [110, 0, 0],
            [110, 0, 10],
            [120, 0, 10],
            [120, 0, 0]
          ], 2)
          that.borderXdraw(group,[
            [110, 0, 40],
            [110, 0, 50],
            [120, 0, 50],
            [120, 0, 40]
          ], 2)
          that.floorGeometry(group, IN_BRIDGE_LF, 32);
          that.floorGeometry(group, GATE_WAY, 2);
          that.floorGeometry(group, TURN, 2);
          that.floorGeometry(group, AG_IN_LF, 32);
          that.floorGeometry(group, AG_RM_1_1, 2);
          that.floorGeometry(group, AG_RM_1_2, 2);
          that.floorGeometry(group, AG_RM_1_3, 2);
          that.floorGeometry(group, AG_RM_1_4, 2);
          that.floorGeometry(group, AG_RM_2_1, 2);
          that.floorGeometry(group, AG_RM_2_2, 2);
          that.floorGeometry(group, AG_RM_2_3, 2);
          that.floorGeometry(group, AG_RM_2_4, 2);
          that.floorGeometry(group, AG_OUT_LF, 32);
          that.floorGeometry(group, INSP, 2);
          that.floorGeometry(group, CL_1, 2);
          that.floorGeometry(group, CL_2, 2);
          that.floorGeometry(group, CL_OUT, 2);
          that.floorGeometry(group, CL_OUT_LF, 32);
          that.floorGeometry(group, CL_OUT_RT, 2);
          that.floorGeometry(group, AG_CL_RT, 2);
          that.floorGeometry(group, FT_IN_LF, 32);
          that.floorGeometry(group, FI_IN_TR, 2);
          ;
          that.floorGeometry(group, FI_1, 2);
          that.borderXdraw(group,[
            [950, 0, 20],
            [950, 0, 30],
            [960, 0, 30],
            [960, 0, 20]
          ], 2)
          that.borderXdraw(group,[
            [950, 0, 30],
            [950, 0, 40],
            [960, 0, 40],
            [960, 0, 30]
          ], 2)
          that.borderXdraw(group,[
            [950, 0, 40],
            [950, 0, 50],
            [960, 0, 50],
            [960, 0, 40]
          ], 2)
          that.floorGeometry(group, FI_2, 2);
          that.borderXdraw(group,[
            [960, 0, 20],
            [960, 0, 30],
            [970, 0, 30],
            [970, 0, 20]
          ], 2)
          that.borderXdraw(group,[
            [960, 0, 30],
            [960, 0, 40],
            [970, 0, 40],
            [970, 0, 30]
          ], 2)
          that.borderXdraw(group,[
            [960, 0, 40],
            [960, 0, 50],
            [970, 0, 50],
            [970, 0, 40]
          ], 2)

          that.floorGeometry(group, FI_TR_1, 2);
          that.floorGeometry(group, FI_TR_2, 2);
          that.floorGeometry(group, FI_3, 2);
          that.borderXdraw(group,[
            [990, 0, 20],
            [990, 0, 30],
            [1000, 0, 30],
            [1000, 0, 20]
          ], 2)
          that.borderXdraw(group,[
            [990, 0, 30],
            [990, 0, 40],
            [1000, 0, 40],
            [1000, 0, 30]
          ], 2)
          that.borderXdraw(group,[
            [990, 0, 40],
            [990, 0, 50],
            [1000, 0, 50],
            [1000, 0, 40]
          ], 2)
          that.floorGeometry(group, FI_4, 2);
          that.borderXdraw(group,[
            [1000, 0, 20],
            [1000, 0, 30],
            [1010, 0, 30],
            [1010, 0, 20]
          ], 2)
          that.borderXdraw(group,[
            [1000, 0, 30],
            [1000, 0, 40],
            [1010, 0, 40],
            [1010, 0, 30]
          ], 2)
          that.borderXdraw(group,[
            [1000, 0, 40],
            [1000, 0, 50],
            [1010, 0, 50],
            [1010, 0, 40]
          ], 2)
          that.floorGeometry(group, FT_IN_TR, 2);
          that.floorGeometry(group, FT_1, 2);
          that.borderXdraw(group,[
            [1020, 0, 10],
            [1020, 0, 20],
            [1030, 0, 20],
            [1030, 0, 10]
          ], 2)
          that.borderXdraw(group,[
            [1020, 0, 20],
            [1020, 0, 30],
            [1030, 0, 30],
            [1030, 0, 20]
          ], 2)
          that.borderXdraw(group,[
            [1020, 0, 30],
            [1020, 0, 40],
            [1030, 0, 40],
            [1030, 0, 30]
          ], 2)
          that.floorGeometry(group, FT_2, 2);
          that.borderXdraw(group,[
            [1030, 0, 10],
            [1030, 0, 20],
            [1040, 0, 20],
            [1040, 0, 10]
          ], 2)
          that.borderXdraw(group,[
            [1030, 0, 20],
            [1030, 0, 30],
            [1040, 0, 30],
            [1040, 0, 20]
          ], 2)
          that.borderXdraw(group,[
            [1030, 0, 30],
            [1030, 0, 40],
            [1040, 0, 40],
            [1040, 0, 30]
          ], 2)
          that.floorGeometry(group, FT_3, 2);
          that.borderXdraw(group,[
            [1040, 0, 10],
            [1040, 0, 20],
            [1050, 0, 20],
            [1050, 0, 10]
          ], 2)
          that.borderXdraw(group,[
            [1040, 0, 20],
            [1040, 0, 30],
            [1050, 0, 30],
            [1050, 0, 20]
          ], 2)
          that.borderXdraw(group,[
            [1040, 0, 30],
            [1040, 0, 40],
            [1050, 0, 40],
            [1050, 0, 30]
          ], 2)
          that.floorGeometry(group, FT_4, 2);
          that.borderXdraw(group,[
            [1050, 0, 10],
            [1050, 0, 20],
            [1060, 0, 20],
            [1060, 0, 10]
          ], 2)
          that.borderXdraw(group,[
            [1050, 0, 20],
            [1050, 0, 30],
            [1060, 0, 30],
            [1060, 0, 20]
          ], 2)
          that.borderXdraw(group,[
            [1050, 0, 30],
            [1050, 0, 40],
            [1060, 0, 40],
            [1060, 0, 30]
          ], 2)
          that.floorGeometry(group, FT_5, 2);
          that.borderXdraw(group,[
            [1060, 0, 0],
            [1060, 0, 10],
            [1070, 0, 10],
            [1070, 0, 0]
          ], 2)
          that.borderXdraw(group,[
            [1060, 0, 10],
            [1060, 0, 20],
            [1070, 0, 20],
            [1070, 0, 10]
          ], 2)
          that.borderXdraw(group,[
            [1060, 0, 20],
            [1060, 0, 30],
            [1070, 0, 30],
            [1070, 0, 20]
          ], 2)
          that.floorGeometry(group, FT_6, 2);
          that.borderXdraw(group,[
            [1070, 0, 0],
            [1070, 0, 10],
            [1080, 0, 10],
            [1080, 0, 0]
          ], 2)
          that.borderXdraw(group,[
            [1070, 0, 10],
            [1070, 0, 20],
            [1080, 0, 20],
            [1080, 0, 10]
          ], 2)
          that.borderXdraw(group,[
            [1070, 0, 20],
            [1070, 0, 30],
            [1080, 0, 30],
            [1080, 0, 20]
          ], 2)
          that.floorGeometry(group, FT_7, 2);
          that.borderXdraw(group,[
            [1080, 0, 0],
            [1080, 0, 10],
            [1090, 0, 10],
            [1090, 0, 0]
          ], 2)
          that.borderXdraw(group,[
            [1080, 0, 10],
            [1080, 0, 20],
            [1090, 0, 20],
            [1090, 0, 10]
          ], 2)
          that.borderXdraw(group,[
            [1080, 0, 20],
            [1080, 0, 30],
            [1090, 0, 30],
            [1090, 0, 20]
          ], 2)
          that.floorGeometry(group, FT_8, 2);
          that.borderXdraw(group,[
            [1090, 0, 0],
            [1090, 0, 10],
            [1100, 0, 10],
            [1100, 0, 0]
          ], 2)
          that.borderXdraw(group,[
            [1090, 0, 10],
            [1090, 0, 20],
            [1100, 0, 20],
            [1100, 0, 10]
          ], 2)
          that.borderXdraw(group,[
            [1090, 0, 20],
            [1090, 0, 30],
            [1100, 0, 30],
            [1100, 0, 20]
          ], 2)
          that.floorGeometry(group, LOAD_OUT, 2);
          that.floorGeometry(group, LOAD_OUT_LF, 32);
          that.floorGeometry(group, FT_RT, 2);
        }

        drawFactory(this, group1);

        var cube = new THREE.Mesh(new THREE.BoxGeometry(4, 4, 4), new THREE.MeshLambertMaterial({color: 0xffdd00}));
        cube.position.x = -20;
        cube.position.y = 2;
        this.floorGroup[0].add(cube);

        this.wall(this.floorGroup[0], [20, 10, 20], [30, 5, -30], 1, [{size: [5, 10, 5], position: [30, 4, -28]}]);

        // Lights
        this.scene.add(new THREE.AmbientLight(0xffffff));
        var directionalLight = new THREE.DirectionalLight(0xffffff, 0.125);
        directionalLight.position.x = Math.random() * 10 - 5;
        directionalLight.position.y = Math.random() * 10 - 5;
        directionalLight.position.z = Math.random() * 10 - 5;
        directionalLight.position.normalize();
        this.scene.add(directionalLight);
        this.pointLight = new THREE.PointLight(0xffffff, 1);
        this.pointLight.position.y = 50;
        this.scene.add(this.pointLight);
        this.renderer.render(this.scene, this.camera);

        window.addEventListener('resize', this.onWindowResize, false);
        //window.addEventListener('click', this.onDocumentMouseClick, false);

        var group2 = new THREE.Group();
        group2.panel = [];
        // group2.position.z = -100;
        // group2.position.x = -600;
        drawFactory(this, group2);
        this.floorGroup.push(group2);
        var m = new THREE.Matrix4();
        var vec = new THREE.Vector3(0, 0, 1);
        m.set(1 - 2 * vec.x * vec.x, -2 * vec.x * vec.y, -2 * vec.x * vec.z, 0,
          -2 * vec.x * vec.y, 1 - 2 * vec.y * vec.y, -2 * vec.y * vec.z, 0,
          -2 * vec.x * vec.z, -2 * vec.y * vec.z, 1 - 2 * vec.z * vec.z, 0,
          0, 0, 0, 1);
        group2.applyMatrix(m);
        group2.translateZ(100);
        group2.translateX(600);

        this.add("08187", 0);
        this.add("09190", 1);

        for(let i=0; i<this.floorGroup.length; i++){
          this.scene.add(this.floorGroup[i])
        }

      },
      add: function (ID, LINE) {
        var materials = [
          new THREE.MeshBasicMaterial( { color: 'blue' } ), // right
          new THREE.MeshBasicMaterial( { color: 'yellow' } ), // left
          new THREE.MeshBasicMaterial( { map: new THREE.CanvasTexture(this.getTextCanvas(ID)) } ), // top
          new THREE.MeshBasicMaterial( { color: 'black' } ), // bottom
          new THREE.MeshBasicMaterial( { color: 'green' } ), // back
          new THREE.MeshBasicMaterial( { color: 'red' } ) // front
        ];
        var panel = new THREE.Mesh(new THREE.CubeGeometry(8, 2, 8), materials);
        panel.position.x = 5;
        panel.position.z = 5;
        panel.position.y = 3;
        panel.data = {id: ID};
        panel.fan = false;
        //this.panel.push(panel);
        this.floorGroup[LINE].panel.push(panel);
        this.floorGroup[LINE].add(panel);
      },
      pathGo: function (panel) {
        if(panel.position.x == 5 && panel.position.z >= 5 && panel.position.z < 25 && panel.position.y == 3){
          panel.position.z +=  1;
        }
        if(panel.position.x >=5 && panel.position.x < 75 && panel.position.z == 25 && panel.position.y == 3){
          panel.position.x +=  1;
        }
        if(panel.position.x == 75 && panel.position.z < 55 && panel.position.y == 3){
          panel.position.z +=  1;
        }
        if(panel.position.x >= 75 && panel.position.x < 85 && panel.position.z == 55 && panel.position.y == 3){
          panel.position.x +=  1;
        }
        if(panel.position.x == 75 && panel.position.z == 55 && panel.position.y == 3) {
          panel.fan = false;
        }
        if(panel.position.x == 85 && panel.position.z <= 55 && panel.position.z > 35 && panel.fan == false){
          panel.position.z -=  1;
        }
        if(panel.position.x == 85 && panel.position.z == 35 && panel.position.y == 3) {
          panel.fan = true;
        }
        if(panel.position.x == 85 && panel.position.z < 45 && panel.fan == true && panel.position.y == 3){
          panel.position.z +=  1;
        }

        if(panel.position.x < 125 && panel.position.z == 45 && panel.fan == true && panel.position.y == 3){
          panel.position.x +=  1;
        }

        if(panel.position.x == 125 && panel.position.y < 32 && panel.position.z == 45){
          panel.position.y +=  1;
        }

        if(panel.position.x >=125 && panel.position.x < 155 && panel.position.z == 45 && panel.position.y == 32) {
          panel.position.x +=  1;
        }

        if(panel.position.x == 155 && panel.position.z == 45 && panel.position.y > 13 && panel.position.y <= 32){
          panel.position.y -=  1;
        }
        if(panel.position.x >= 155 && panel.position.x < 595 && panel.position.z == 45 && panel.position.y == 13){
          panel.position.x +=  1;
        }

        if(panel.position.x == 595 && panel.position.y > 3 && panel.position.y <= 13 && panel.position.z == 45){
          panel.position.y -=  1;
        }

        if(panel.position.x== 595 && panel.position.y == 3 && panel.position.z > 35 && panel.position.z <= 45){
          panel.position.z -=  1;
        }
        if(panel.position.x >= 595 && panel.position.x < 905 && panel.position.y == 3 && panel.position.z == 35){
          panel.position.x +=  1;
        }
        if(panel.position.x == 905 && panel.position.y < 33 && panel.position.y >=3 && panel.position.z == 35){
          panel.position.y +=  1;
        }

        if(panel.position.x >= 905 && panel.position.x < 935 && panel.position.y == 33 && panel.position.z == 35){
          panel.position.x +=  1;
        }

        if(panel.position.x == 935 && panel.position.y > 3 && panel.position.y <= 33 &&  panel.position.z == 35){
          panel.position.y -=  1;
        }

        if(panel.position.x >= 935 && panel.position.x < 945 && panel.position.y == 3 && panel.position.z == 35){
          panel.position.x +=  1;
        }

        if(panel.position.x >= 945 && panel.position.x < 1055 && panel.position.y == 3 && panel.position.z == 35){
          panel.position.x +=  1;
        }
        if(panel.position.x == 1055 && panel.position.y == 3 && panel.position.z > 25 && panel.position.z <=35){
          panel.position.z -=  1;
        }

        if(panel.position.x >= 1055 && panel.position.x < 1135 && panel.position.y == 3 && panel.position.z == 25){
          panel.position.x +=  1;
        }
        if(panel.position.x == 1135 && panel.position.y < 33 && panel.position.y >= 3 && panel.position.z == 25){
          panel.position.y +=  1;
        }

        if(panel.position.x > 915 && panel.position.x <= 1135 && panel.position.y == 33 && panel.position.z == 25){
          panel.position.x -=  1;
        }
        if(panel.position.x == 915 && panel.position.y == 33 && panel.position.z > 5 && panel.position.z <= 25){
          panel.position.z -=  1;
        }
        if(panel.position.x <= 915 && panel.position.x > 35 && panel.position.y == 33 && panel.position.z == 5){
          panel.position.x -=  1;
        }

        if(panel.position.x == 35 && panel.position.y <= 33 && panel.position.y > 3 && panel.position.z == 5){
          panel.position.y -=  1;
        }

        if(panel.position.x <= 35 && panel.position.x > 5 && panel.position.y == 3 && panel.position.z == 5){
          panel.position.x -=  1;
        }
      },
      animate: function () {
        requestAnimationFrame(this.animate);
        if (this.stop === false) {
          for(let i=0; i<this.floorGroup.length; i++){
            for(let j=0; j<this.floorGroup[i].panel.length; j++){
              this.pathGo(this.floorGroup[i].panel[j]);
            }
          }
        }

        this.controls.update();
        this.renderer.render(this.scene, this.camera);
      },
      floorGeometry: function (group, points, height) {
        var topPoints = [];
        for (var i = 0; i < points.length; i++) {
          var vertice = points[i];
          topPoints.push([vertice[0], vertice[1] + height, vertice[2]]);
        }
        var totalPoints = points.concat(topPoints);
        var vertices = [];           //所有的顶点
        for (var i = 0; i < totalPoints.length; i++) {
          vertices.push(new THREE.Vector3(totalPoints[i][0], totalPoints[i][1], totalPoints[i][2]))
        }
        var length = points.length;
        var faces = [];
        for (var j = 0; j < length; j++) {                      //侧面生成三角形
          if (j != length - 1) {
            faces.push(new THREE.Face3(j, j + 1, length + j + 1));
            faces.push(new THREE.Face3(length + j + 1, length + j, j));
          } else {
            faces.push(new THREE.Face3(j, 0, length));
            faces.push(new THREE.Face3(length, length + j, j));
          }
        }
        var data = [];
        for (var i = 0; i < length; i++) {
          data.push(points[i][0], points[i][2]);
        }
        var triangles = earcut(data);
        if (triangles && triangles.length != 0) {
          for (var i = 0; i < triangles.length; i++) {
            var tlength = triangles.length;
            if (i % 3 == 0 && i < tlength - 2) {
              faces.push(new THREE.Face3(triangles[i], triangles[i + 1], triangles[i + 2]));                            //底部的三角面
              faces.push(new THREE.Face3(triangles[i] + length, triangles[i + 1] + length, triangles[i + 2] + length));        //顶部的三角面
            }
          }
        }
        var geometry = new THREE.Geometry();
        geometry.vertices = vertices;
        geometry.faces = faces;
        geometry.computeFaceNormals();      //自动计算法向量

        var material = new THREE.MeshLambertMaterial({color: 0x666666, side: THREE.DoubleSide});
        var mesh = new THREE.Mesh(geometry, material);
        group.add(mesh);
        //return mesh;
        this.borderGeometry(group, points, height);
      },
      borderGeometry: function (group, points, height) {
        var geometry = new THREE.Geometry();
        for (var i = 0; i < points.length; i++) {
          var point = points[i];
          geometry.vertices.push(new THREE.Vector3(point[0], point[1] + height, point[2]));
          if (i == points.length - 1) {
            geometry.vertices.push(new THREE.Vector3(points[0][0], points[0][1] + height, points[0][2]));
          }
        }

        var mesh2 = new THREE.Line(geometry, new THREE.MeshLambertMaterial({color: 0xffffff}));
        group.add(mesh2);
        //return mesh2;
      },
      borderXdraw: function (group, points, height) {
        var geometry = new THREE.Geometry();
        for (var i = 0; i < points.length; i++) {
          var point = points[i];
          geometry.vertices.push(new THREE.Vector3(point[0], point[1] + height, point[2]));
          if (i == points.length - 1) {
            geometry.vertices.push(new THREE.Vector3(points[0][0], points[0][1] + height, points[0][2]));
          }
        }
        geometry.vertices.push(new THREE.Vector3(points[2][0], points[2][1] + height, points[2][2]));
        geometry.vertices.push(new THREE.Vector3(points[3][0], points[3][1] + height, points[3][2]));
        geometry.vertices.push(new THREE.Vector3(points[1][0], points[1][1] + height, points[1][2]));

        var mesh2 = new THREE.Line(geometry, new THREE.MeshLambertMaterial({color: 0xffffff}));
        group.add(mesh2);
      },
      wall: function (group, size, position, rotation, holes) {
        var geometry = new THREE.BoxGeometry(size[0], size[1], size[2]);
        var materials = new THREE.MeshLambertMaterial({color: 0x888888, side: THREE.DoubleSide})
        var result = new THREE.Mesh(geometry, materials);
        result.position.x = position[0];
        result.position.y = position[1];
        result.position.z = position[2];
        if (holes) {
          //result = cube;
          for (var i = 0; i < holes.length; i++) {
            var totalBSP = new ThreeBSP(result);
            var hole = holes[i];
            var holeGeometry = new THREE.BoxGeometry(hole.size[0], hole.size[1], hole.size[2]);
            var holeCube = new THREE.Mesh(holeGeometry);
            holeCube.position.x = hole.position[0];
            //holeCube.position.y = hole.position[1] + hole.size[1]/2;
            holeCube.position.y = 5;
            holeCube.position.z = hole.position[2];
            var clipBSP = new ThreeBSP(holeCube);
            var resultBSP = totalBSP.subtract(clipBSP);
            result = resultBSP.toMesh();
          }
          result.material = materials;
        }
        group.add(result);             //添加填充
      },
      onDocumentMouseClick: function (event) {
        //event.preventDefault();
        if (this.selectedObject) {
          // this.selectedObject.material.color.set( '#'+this.selectedColor );
          this.selectedObject.material = new THREE.MeshLambertMaterial({
            color: "#" + this.selectedColor,
            side: THREE.DoubleSide
          });
          this.selectedObject = null;
        }
        var vector = new THREE.Vector3();//三维坐标对象
        vector.set(
          (event.layerX / this.width) * 2 - 1,
          -(event.layerY / this.height) * 2 + 1,
          0.5
        );
        var raycaster = new THREE.Raycaster();
        raycaster.setFromCamera(vector, this.camera);
        //var intersects = [];        //楼层中的元素
        for(let i=0; i<this.floorGroup.length; i++){
          var intersects = raycaster.intersectObjects(this.floorGroup[i].children);
          if (intersects.length > 0) {
            this.selectedObject = intersects[0].object;
            if(this.selectedObject.data !== undefined){
              alert("Pallet ID: " + this.selectedObject.data.id);
              this.selectedObject = null;
            } else {
              this.selectedColor = this.selectedObject.material.color.getHexString();
              //this.selectedObject.material.color.set( '#f00' );
              this.selectedObject.material = new THREE.MeshLambertMaterial({color: "#f86332", side: THREE.DoubleSide});
            }       //选中的样式
          }
        }

        this.renderer.render(this.scene, this.camera);
      },
      onWindowResize() {
        this.width = window.innerWidth - 50;
        this.height = window.innerHeight - 130;
        this.camera.aspect = this.width / this.height;
        this.camera.updateProjectionMatrix();
        this.renderer.setSize(this.width, this.height);
        this.controls.handleResize();
      },
      drawPanel(id) {
        var c = document.createElement( 'canvas' );
        c.width = 10;
        c.height = 10;
        c.style= "border:1px solid #d3d3d3;";
        var ctx = c.getContext('2d');
        ctx.font="5px Arial";
        ctx.fillStyle="#FF0000";
        ctx.fillText("09190",0,10);


        // // Create gradient
        // var grd=ctx.createLinearGradient(0,0,10,0);
        // grd.addColorStop(0,"red");
        // grd.addColorStop(1,"white");
        // // Fill with gradient
        // ctx.fillStyle=grd;
        // ctx.fillRect(0,0,10,10);

        return c;
      },
      getTextCanvas(text){
        var width=512, height=256;
        var canvas = document.createElement('canvas');
        canvas.width = width;
        canvas.height = height;
        var ctx = canvas.getContext('2d');
        ctx.fillStyle = '#FF0000';
        ctx.fillRect(0, 0, width, height);
        ctx.font = 150+'px " bold';
        ctx.fillStyle = '#000000';
        ctx.textAlign = 'center';
        ctx.textBaseline = 'middle';
        ctx.fillText(text, width/2,height/2);
        return canvas;
      }

    },
    mounted () {
      this.init()
      this.animate()
    }
  }
</script>

<style scoped>

</style>
