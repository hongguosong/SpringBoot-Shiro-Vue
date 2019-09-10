<template>
  <div id="dashboard">
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
    <el-button @click="remoteStart" size="mini">remoteStart</el-button>

    <el-card>
      <div id="container" @click="onDocumentMouseClick">
        <!-- <div class="alarm-count animated fadeIn infinite" v-show="alarmList.length">
          <a href="#myTable">{{alarmList.length}}</a>
        </div> -->
      </div>
    </el-card>

    <!--<el-row :gutter="3">-->
    <!--<el-col :span="12">-->
    <!--<el-card>-->
    <!--<el-table :data="state1" style="width:100%;text-align: center;" border size="mini">-->
    <!--<el-table-column prop="C1" label="C1" min-width="38"></el-table-column>-->
    <!--<el-table-column label="I" width="20">-->
    <!--<template slot-scope="scope">-->
    <!--<div class="stateBack" v-bind:style="{background: scope.row.I}"></div>-->
    <!--</template>-->
    <!--</el-table-column>-->
    <!--<el-table-column v-for="(value1,index) in 43" :key="index" width="18" align="center">-->
    <!--<template slot="header" slot-scope="scope">-->
    <!--{{43-value1+1}}-->
    <!--</template>-->
    <!--<template slot-scope="scope">-->
    <!--<div class="stateBack" v-bind:style="{background: palletColor(scope.row, 43-value1+1)}"></div>-->
    <!--</template>-->
    <!--</el-table-column>-->
    <!--<el-table-column label="O" width="20">-->
    <!--<template slot-scope="scope">-->
    <!--<div class="stateBack" v-bind:style="{background: scope.row.O}"></div>-->
    <!--</template>-->
    <!--</el-table-column>-->
    <!--</el-table>-->
    <!--</el-card>-->
    <!--</el-col>-->
    <!--<el-col :span="12">-->
    <!--<el-card>-->
    <!--<el-table :data="state2" style="width:100%;text-align: center;" border size="mini">-->
    <!--<el-table-column prop="C2" label="C2" min-width="38"></el-table-column>-->
    <!--<el-table-column label="I" width="20">-->
    <!--<template slot-scope="scope">-->
    <!--<div class="stateBack" v-bind:style="{background: scope.row.I}"></div>-->
    <!--</template>-->
    <!--</el-table-column>-->
    <!--<el-table-column v-for="(value1,index) in 43" :key="index" width="18" align="center">-->
    <!--<template slot="header" slot-scope="scope">-->
    <!--{{43-value1+1}}-->
    <!--</template>-->
    <!--<template slot-scope="scope">-->
    <!--<div class="stateBack" v-bind:style="{background: palletColor(scope.row, 43-value1+1)}"></div>-->
    <!--</template>-->
    <!--</el-table-column>-->
    <!--<el-table-column label="O" width="20">-->
    <!--<template slot-scope="scope">-->
    <!--<div class="stateBack" v-bind:style="{background: scope.row.O}"></div>-->
    <!--</template>-->
    <!--</el-table-column>-->
    <!--</el-table>-->
    <!--</el-card>-->
    <!--</el-col>-->
    <!--</el-row>-->
    <el-row style="margin-top: 3px;">
      <!--<el-collapse v-model="activeName" accordion>-->
      <!--<el-collapse-item title="C1" name="1">-->
      <!--<el-table :data="agingC1" style="width:100%;text-align: center;" border size="mini">-->
      <!--<el-table-column prop="C1" label="C1" width="55"></el-table-column>-->
      <!--<el-table-column v-for="(value1,index) in 43" :key="index" width="42" align="center">-->
      <!--<template slot="header" slot-scope="scope">-->
      <!--{{43-value1+1}}-->
      <!--</template>-->
      <!--<template slot-scope="scope">-->
      <!--<div class="agingBack">{{stateColor(scope.row, 43-value1+1)}}</div>-->
      <!--</template>-->
      <!--</el-table-column>-->
      <!--</el-table>-->
      <!--</el-collapse-item>-->
      <!--<el-collapse-item title="C2" name="2">-->
      <!--<el-table :data="agingC1" style="width:100%;text-align: center;" border size="mini">-->
      <!--<el-table-column prop="C1" label="C1" width="55"></el-table-column>-->
      <!--<el-table-column v-for="(value1,index) in 43" :key="index" width="42" align="center">-->
      <!--<template slot="header" slot-scope="scope">-->
      <!--{{43-value1+1}}-->
      <!--</template>-->
      <!--<template slot-scope="scope">-->
      <!--<div class="agingBack">{{stateColor(scope.row, 43-value1+1)}}</div>-->
      <!--</template>-->
      <!--</el-table-column>-->
      <!--</el-table>-->
      <!--</el-collapse-item>-->
      <!--</el-collapse>-->

      <el-tabs tab-position="left" type="border-card" class="myTable">
        <el-tab-pane label="C1">
          <el-table :data="agingC1"  style="width:100%;text-align: center;" border size="mini">
            <el-table-column prop="C1" label="C1" min-width="52"></el-table-column>
            <el-table-column v-for="(value1,index) in 43" :key="index" width="40" align="center">
              <template slot="header" slot-scope="scope"> <!-- eslint-disable-line -->
                {{43-value1+1}}
              </template>
              <template slot-scope="scope">
                <div class="agingBack" v-bind:style="{backgroundColor: stateColor(scope.row, 43-value1+1)}" v-if="stateId(scope.row, 43-value1+1)">{{stateId(scope.row, 43-value1+1)}}</div>
              </template>
            </el-table-column>
          </el-table>
        </el-tab-pane>
        <el-tab-pane label="C2">
          <el-table :data="agingC2" style="width:100%;text-align: center;" border size="mini">
            <el-table-column prop="C2" label="C2" min-width="52"></el-table-column>
            <el-table-column v-for="(value1,index) in 43" :key="index" width="40" align="center">
              <template slot="header" slot-scope="scope"> <!-- eslint-disable-line -->
                {{43-value1+1}}
              </template>
              <template slot-scope="scope">
                <div class="agingBack" v-bind:style="{backgroundColor: stateColor(scope.row, 43-value1+1)}" v-if="stateId(scope.row, 43-value1+1)">{{stateId(scope.row, 43-value1+1)}}</div>
              </template>
            </el-table-column>
          </el-table>
        </el-tab-pane>
      </el-tabs>
    </el-row>
    <!--<aging-room :width="width" :height="height"></aging-room>-->
    <el-row :gutter="3" style="margin-top: 3px;">
      <el-col :xs="12" :sm="12" :md="12" :lg="6" :xl="6">
        <el-card>
          <div id="chartCounter" style="width:100%; height: 192px;"></div>
        </el-card>
      </el-col>
      <el-col :xs="12" :sm="12" :md="12" :lg="6" :xl="6">
        <el-card>
          <div id="chartTemp" style="width:100%; height: 192px;"></div>
        </el-card>
      </el-col>
      <el-col :xs="12" :sm="12" :md="12" :lg="6" :xl="6">
        <el-card>
          <!-- <el-input
            type="textarea"
            :rows="10"
            v-model="log"
            :disabled="true">
          </el-input> -->
          <div id="chartMachineState" style="width:100%; height: 192px;"></div>
        </el-card>
      </el-col>
      <el-col :xs="12" :sm="12" :md="12" :lg="6" :xl="6">
        <el-card>
          <div style="width: 100%;height: 192px; text-align: center">
            <div v-for="(item,index) in plcConnections" :key="index" class="connectionDiv" v-bind:style="{background: item.con}">
              <div class="connectionDiv-time">{{item.time}}</div>
              <div class="connectionDiv-name">{{item.name}}</div>

            </div>
          </div>
        </el-card>
      </el-col>
    </el-row>
    <el-row :gutter="3" style="margin-top: 3px;">
      <el-col :xs="12" :sm="12" :md="12" :lg="6" :xl="6">
        <el-card>
          <div id="chartCapacity" style="width:100%; height: 192px;"></div>
        </el-card>
      </el-col>
      <el-col :xs="12" :sm="12" :md="12" :lg="6" :xl="6">
        <el-card>
          <div id="chartTactTime" style="width:100%; height: 192px;"></div>
        </el-card>
      </el-col>
      <el-col :xs="12" :sm="12" :md="12" :lg="6" :xl="6">
        <el-card id="myTable" class="myTable">
          <el-table style="width: 100%;height: 192px;" :data="alarmList" border height="192">
            <el-table-column prop="id" label="id" width="40"></el-table-column>
            <el-table-column prop="unit" label="unit" width="60"></el-table-column>
            <el-table-column prop="desc" label="desc"></el-table-column>
            <el-table-column prop="start" label="start"></el-table-column>
            <el-table-column prop="end" label="end"></el-table-column>
          </el-table>
        </el-card>
      </el-col>
      <el-col :xs="12" :sm="12" :md="12" :lg="6" :xl="6">
        <el-card>
          <div style="width: 100%;height: 192px; text-align: center">
            <div v-for="(item,index) in pcConnections" :key="index" class="pcConnectionDiv" v-bind:style="{background: item.con}">
              <div style="padding: 5px 0; margin-top: -30px; margin-left: -55px;transform: rotate(45deg);word-break:break-all;">{{item.name}}</div>
            </div>
          </div>
        </el-card>
      </el-col>
    </el-row>
    <el-dialog title="Pallet Information" :visible.sync="dialogTable.visible">
      <el-form :model="dialogTable" label-width="120px" label-position="left">
        <el-form-item label="Pallet ID:">
          <span>{{dialogTable.palletId}}</span>
        </el-form-item>
        <el-form-item label="Recipe:">
          <span>{{dialogTable.recipe}}</span>
        </el-form-item>
        <el-form-item label="State:">
          <div style="display: block; width: 15px;height:15px;border-radius:15px;margin-top:5px;" :style="{backgroundColor: dialogTable.state}"></div>
        </el-form-item>
      </el-form>
    </el-dialog>
  </div>
</template>

<script>
import { mapMutations } from 'vuex'
import * as THREE from 'three'
import earcut from 'earcut'
import ThreeBSP from '@/api/ThreeBSP'
import TrackballControls from '@/api/TrackballControls.js'
// import OrbitControls from '@/api/OrbitControls.js'
import TWEEN from '@/api/Tween.js'
// import AgingRoom from '@/views/business/AgingRoom.vue'
export default {
  // components: { AgingRoom },
  name: 'floor',
  // component: {
  //   'aging-room': AgingRoom
  // },
  data () {
    return {
      startLabel: 'start',
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
      dialogTable: {
        visible: false,
        palletId: '',
        recipe: '',
        state: ''
      },

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
      width: window.innerWidth - 40,
      height: 400 * window.innerHeight / 1080,
      machineObject: {},
      pcObject: {},
      plcObject: {},
      selectedObject: null,
      selectedColor: null,
      pallet: [
        [[{ p: null }, { p: null }, { p: null }], // 1层1列
          [{ p: null }], // 1层2列
          [{ p: null }, { p: null }, { p: null }, { p: null }, { p: null }, { p: null }, { p: null }, { p: null }], // 1层3列
          [{}, {}, {}, {}, {}, {}, {}, { p: null }, { p: null }, { p: null }, { p: null }, { p: null }, {}, {}, {}, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }, { p: null }], // 1层4列
          [{}, {}, {}, {}, {}, {}, {}, { p: null }, { p: null }, { p: null }, { p: null }, { p: null }, { p: null }, {}, {}, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }, { p: null },
            {}, { p: null }, {}, { p: null }, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }, {}], // 1层5列
          [{}, {}, {}, {}, {}, {}, {}, { P: null }]], // 1层6列
        [[], // 2层1列
          [], // 2层2列
          [], // 2层3列
          [{}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }], // 2层4列
          [{}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }], // 2层5列
          [] // 2层6列
        ],
        [[], // 3层1列
          [], // 3层2列
          [], // 3层3列
          [{}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }], // 3层4列
          [{}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }], // 3层5列
          []],
        [[], // 4层1列
          [], // 4层2列
          [], // 4层3列
          [{}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }], // 4层4列
          [{}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, { p: null }, { p: null }, { p: null }, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }, { p: null },
            { p: null }, { p: null }, { p: null }, { p: null }], // 4层5列
          []]
      ],
      data: [
        [[{ id: '08090', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '08091', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '08092', x: 0, y: 0, z: 0, m: 1, o: 0 }], // 1层1列
          [{ id: '08093', x: 0, y: 0, z: 0, m: 1, o: 0 }], // 1层2列
          [{ id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '08094', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '08095', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '08096', x: 0, y: 0, z: 0, m: 1, o: 0 }], // 1层3列
          [{}, {}, {}, {}, {}, {}, {},
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            {}, {}, {},
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }], // 1层4列
          [{}, {}, {}, {}, {}, {}, {},
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, {}, {},
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            {}, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, {}, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }], // 1层5列
          [{}, {}, {}, {}, {}, {}, {}, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }]], // 1层6列
        [ [], // 2层1列
          [], // 2层2列
          [], // 2层3列
          [{}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }], // 2层4列
          [{}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }], // 2层5列
          [] // 2层6列
        ],
        [[], // 3层1列
          [], // 3层2列
          [], // 3层3列
          [{}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }], // 3层4列
          [{}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }], // 3层5列
          []],
        [[], // 4层1列
          [], // 4层2列
          [], // 4层3列
          [{}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }], // 4层4列
          [{}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, { id: '08022', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '08023', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '08024', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '08025', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 },
            { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }, { id: '', x: 0, y: 0, z: 0, m: 1, o: 0 }], // 4层5列
          []]
      ],
      oldData: null,
      state1: [
        { 'C1': 'F1',
          'I': '',
          'd43': 'red',
          'd42': 'green',
          'd41': 'red',
          'd40': 'green',
          'd39': 'red',
          'd38': 'green',
          'd37': 'red',
          'd36': 'green',
          'd35': 'red',
          'd34': 'green',
          'd33': 'red',
          'd32': 'green',
          'd31': 'green',
          'd30': 'green',
          'd29': 'red',
          'd28': 'green',
          'd27': 'red',
          'd26': 'green',
          'd25': 'red',
          'd24': 'green',
          'd23': 'red',
          'd22': 'green',
          'd21': 'green',
          'd20': 'green',
          'd19': 'red',
          'd18': 'green',
          'd17': 'red',
          'd16': 'green',
          'd15': 'red',
          'd14': 'green',
          'd13': 'red',
          'd12': 'green',
          'd11': 'green',
          'd10': 'green',
          'd9': 'red',
          'd8': 'green',
          'd7': 'red',
          'd6': 'green',
          'd5': 'red',
          'd4': 'green',
          'd3': 'red',
          'd2': 'green',
          'd1': 'green',
          'O': 'red' },
        { 'C1': 'F2',
          'I': '',
          'd43': 'red',
          'd42': 'green',
          'd41': 'red',
          'd40': 'green',
          'd39': 'red',
          'd38': 'green',
          'd37': 'red',
          'd36': 'green',
          'd35': 'red',
          'd34': 'green',
          'd33': 'red',
          'd32': 'green',
          'd31': 'green',
          'd30': 'green',
          'd29': 'red',
          'd28': 'green',
          'd27': 'red',
          'd26': 'green',
          'd25': 'red',
          'd24': 'green',
          'd23': 'red',
          'd22': 'green',
          'd21': 'green',
          'd20': 'green',
          'd19': 'red',
          'd18': 'green',
          'd17': 'red',
          'd16': 'green',
          'd15': 'red',
          'd14': 'green',
          'd13': 'red',
          'd12': 'green',
          'd11': 'green',
          'd10': 'green',
          'd9': 'red',
          'd8': 'green',
          'd7': 'red',
          'd6': 'green',
          'd5': 'red',
          'd4': 'green',
          'd3': 'red',
          'd2': 'green',
          'd1': 'green',
          'O': 'red' },
        { 'C1': 'F3',
          'I': '',
          'd43': 'red',
          'd42': 'green',
          'd41': 'red',
          'd40': 'green',
          'd39': 'red',
          'd38': 'green',
          'd37': 'red',
          'd36': 'green',
          'd35': 'red',
          'd34': 'green',
          'd33': 'red',
          'd32': 'green',
          'd31': 'green',
          'd30': 'green',
          'd29': 'red',
          'd28': 'green',
          'd27': 'red',
          'd26': 'green',
          'd25': 'red',
          'd24': 'green',
          'd23': 'red',
          'd22': 'green',
          'd21': 'green',
          'd20': 'green',
          'd19': 'red',
          'd18': 'green',
          'd17': 'red',
          'd16': 'green',
          'd15': 'red',
          'd14': 'green',
          'd13': 'red',
          'd12': 'green',
          'd11': 'green',
          'd10': 'green',
          'd9': 'red',
          'd8': 'green',
          'd7': 'red',
          'd6': 'green',
          'd5': 'red',
          'd4': 'green',
          'd3': 'red',
          'd2': 'green',
          'd1': 'green',
          'O': 'red' },
        { 'C1': 'F4',
          'I': '',
          'd43': 'red',
          'd42': 'green',
          'd41': 'red',
          'd40': 'green',
          'd39': 'red',
          'd38': 'green',
          'd37': 'red',
          'd36': 'green',
          'd35': 'red',
          'd34': 'green',
          'd33': 'red',
          'd32': 'green',
          'd31': 'green',
          'd30': 'green',
          'd29': 'red',
          'd28': 'green',
          'd27': 'red',
          'd26': 'green',
          'd25': 'red',
          'd24': 'green',
          'd23': 'red',
          'd22': 'green',
          'd21': 'green',
          'd20': 'green',
          'd19': 'red',
          'd18': 'green',
          'd17': 'red',
          'd16': 'green',
          'd15': 'red',
          'd14': 'green',
          'd13': 'red',
          'd12': 'green',
          'd11': 'green',
          'd10': 'green',
          'd9': 'red',
          'd8': 'green',
          'd7': 'red',
          'd6': 'green',
          'd5': 'red',
          'd4': 'green',
          'd3': 'red',
          'd2': 'green',
          'd1': 'green',
          'O': 'red' }
      ],
      state2: [
        { 'C2': 'F1',
          'I': '',
          'd43': 'red',
          'd42': 'green',
          'd41': 'red',
          'd40': 'green',
          'd39': 'red',
          'd38': 'green',
          'd37': 'red',
          'd36': 'green',
          'd35': 'red',
          'd34': 'green',
          'd33': 'red',
          'd32': 'green',
          'd31': 'green',
          'd30': 'green',
          'd29': 'red',
          'd28': 'green',
          'd27': 'red',
          'd26': 'green',
          'd25': 'red',
          'd24': 'green',
          'd23': 'red',
          'd22': 'green',
          'd21': 'green',
          'd20': 'green',
          'd19': 'red',
          'd18': 'green',
          'd17': 'red',
          'd16': 'green',
          'd15': 'red',
          'd14': 'green',
          'd13': 'red',
          'd12': 'green',
          'd11': 'green',
          'd10': 'green',
          'd9': 'red',
          'd8': 'green',
          'd7': 'red',
          'd6': 'green',
          'd5': 'red',
          'd4': 'green',
          'd3': 'red',
          'd2': 'green',
          'd1': 'green',
          'O': 'red' },
        { 'C2': 'F2',
          'I': '',
          'd43': 'red',
          'd42': 'green',
          'd41': 'red',
          'd40': 'green',
          'd39': 'red',
          'd38': 'green',
          'd37': 'red',
          'd36': 'green',
          'd35': 'red',
          'd34': 'green',
          'd33': 'red',
          'd32': 'green',
          'd31': 'green',
          'd30': 'green',
          'd29': 'red',
          'd28': 'green',
          'd27': 'red',
          'd26': 'green',
          'd25': 'red',
          'd24': 'green',
          'd23': 'red',
          'd22': 'green',
          'd21': 'green',
          'd20': 'green',
          'd19': 'red',
          'd18': 'green',
          'd17': 'red',
          'd16': 'green',
          'd15': 'red',
          'd14': 'green',
          'd13': 'red',
          'd12': 'green',
          'd11': 'green',
          'd10': 'green',
          'd9': 'red',
          'd8': 'green',
          'd7': 'red',
          'd6': 'green',
          'd5': 'red',
          'd4': 'green',
          'd3': 'red',
          'd2': 'green',
          'd1': 'green',
          'O': 'red' },
        { 'C2': 'F3',
          'I': '',
          'd43': 'red',
          'd42': 'green',
          'd41': 'red',
          'd40': 'green',
          'd39': 'red',
          'd38': 'green',
          'd37': 'red',
          'd36': 'green',
          'd35': 'red',
          'd34': 'green',
          'd33': 'red',
          'd32': 'green',
          'd31': 'green',
          'd30': 'green',
          'd29': 'red',
          'd28': 'green',
          'd27': 'red',
          'd26': 'green',
          'd25': 'red',
          'd24': 'green',
          'd23': 'red',
          'd22': 'green',
          'd21': 'green',
          'd20': 'green',
          'd19': 'red',
          'd18': 'green',
          'd17': 'red',
          'd16': 'green',
          'd15': 'red',
          'd14': 'green',
          'd13': 'red',
          'd12': 'green',
          'd11': 'green',
          'd10': 'green',
          'd9': 'red',
          'd8': 'green',
          'd7': 'red',
          'd6': 'green',
          'd5': 'red',
          'd4': 'green',
          'd3': 'red',
          'd2': 'green',
          'd1': 'green',
          'O': 'red' },
        { 'C2': 'F4',
          'I': '',
          'd43': 'red',
          'd42': 'green',
          'd41': 'red',
          'd40': 'green',
          'd39': 'red',
          'd38': 'green',
          'd37': 'red',
          'd36': 'green',
          'd35': 'red',
          'd34': 'green',
          'd33': 'red',
          'd32': 'green',
          'd31': 'green',
          'd30': 'green',
          'd29': 'red',
          'd28': 'green',
          'd27': 'red',
          'd26': 'green',
          'd25': 'red',
          'd24': 'green',
          'd23': 'red',
          'd22': 'green',
          'd21': 'green',
          'd20': 'green',
          'd19': 'red',
          'd18': 'green',
          'd17': 'red',
          'd16': 'green',
          'd15': 'red',
          'd14': 'green',
          'd13': 'red',
          'd12': 'green',
          'd11': 'green',
          'd10': 'green',
          'd9': 'red',
          'd8': 'green',
          'd7': 'red',
          'd6': 'green',
          'd5': 'red',
          'd4': 'green',
          'd3': 'red',
          'd2': 'green',
          'd1': 'green',
          'O': 'red' }
      ],
      agingC1: [
        { 'C1': 'F1',
          'd43': { 'id': '', 'c': '' },
          'd42': { 'id': '08090', 'c': 'green' },
          'd41': { 'id': '08090', 'c': 'green' },
          'd40': { 'id': '08090', 'c': 'green' },
          'd39': { 'id': '08090', 'c': 'green' },
          'd38': { 'id': '08090', 'c': 'green' },
          'd37': { 'id': '08090', 'c': 'green' },
          'd36': { 'id': '08090', 'c': 'green' },
          'd35': { 'id': '08090', 'c': 'green' },
          'd34': { 'id': '08090', 'c': 'green' },
          'd33': { 'id': '08090', 'c': 'green' },
          'd32': { 'id': '08090', 'c': 'green' },
          'd31': { 'id': '08090', 'c': 'green' },
          'd30': { 'id': '08090', 'c': 'green' },
          'd29': { 'id': '08090', 'c': 'green' },
          'd28': { 'id': '08090', 'c': 'green' },
          'd27': { 'id': '08090', 'c': 'green' },
          'd26': { 'id': '08090', 'c': 'green' },
          'd25': { 'id': '08090', 'c': 'green' },
          'd24': { 'id': '08090', 'c': 'green' },
          'd23': { 'id': '08090', 'c': 'green' },
          'd22': { 'id': '08090', 'c': 'green' },
          'd21': { 'id': '08090', 'c': 'green' },
          'd20': { 'id': '08090', 'c': 'green' },
          'd19': { 'id': '08090', 'c': 'green' },
          'd18': { 'id': '08090', 'c': 'green' },
          'd17': { 'id': '08090', 'c': 'green' },
          'd16': { 'id': '08090', 'c': 'green' },
          'd15': { 'id': '08090', 'c': 'green' },
          'd14': { 'id': '08090', 'c': 'green' },
          'd13': { 'id': '08090', 'c': 'green' },
          'd12': { 'id': '08090', 'c': 'green' },
          'd11': { 'id': '08090', 'c': 'green' },
          'd10': { 'id': '08090', 'c': 'green' },
          'd9': { 'id': '08090', 'c': 'green' },
          'd8': { 'id': '08090', 'c': 'green' },
          'd7': { 'id': '08090', 'c': 'green' },
          'd6': { 'id': '08090', 'c': 'green' },
          'd5': { 'id': '08090', 'c': 'green' },
          'd4': { 'id': '08090', 'c': 'green' },
          'd3': { 'id': '08090', 'c': 'green' },
          'd2': { 'id': '08090', 'c': 'green' },
          'd1': { 'id': '08090', 'c': 'red' } },
        { 'C1': 'F2',
          'd43': { 'id': '08090', 'c': 'green' },
          'd42': { 'id': '08090', 'c': 'green' },
          'd41': { 'id': '08090', 'c': 'green' },
          'd40': { 'id': '08090', 'c': 'green' },
          'd39': { 'id': '08090', 'c': 'green' },
          'd38': { 'id': '08090', 'c': 'green' },
          'd37': { 'id': '08090', 'c': 'green' },
          'd36': { 'id': '08090', 'c': 'green' },
          'd35': { 'id': '08090', 'c': 'green' },
          'd34': { 'id': '08090', 'c': 'green' },
          'd33': { 'id': '08090', 'c': 'green' },
          'd32': { 'id': '08090', 'c': 'green' },
          'd31': { 'id': '08090', 'c': 'green' },
          'd30': { 'id': '08090', 'c': 'green' },
          'd29': { 'id': '08090', 'c': 'green' },
          'd28': { 'id': '08090', 'c': 'green' },
          'd27': { 'id': '08090', 'c': 'green' },
          'd26': { 'id': '08090', 'c': 'green' },
          'd25': { 'id': '08090', 'c': 'green' },
          'd24': { 'id': '08090', 'c': 'green' },
          'd23': { 'id': '08090', 'c': 'green' },
          'd22': { 'id': '08090', 'c': 'green' },
          'd21': { 'id': '08090', 'c': 'green' },
          'd20': { 'id': '08090', 'c': 'green' },
          'd19': { 'id': '08090', 'c': 'green' },
          'd18': { 'id': '08090', 'c': 'green' },
          'd17': { 'id': '08090', 'c': 'green' },
          'd16': { 'id': '08090', 'c': 'green' },
          'd15': { 'id': '08090', 'c': 'green' },
          'd14': { 'id': '08090', 'c': 'green' },
          'd13': { 'id': '08090', 'c': 'green' },
          'd12': { 'id': '08090', 'c': 'green' },
          'd11': { 'id': '08090', 'c': 'green' },
          'd10': { 'id': '08090', 'c': 'green' },
          'd9': { 'id': '08090', 'c': 'green' },
          'd8': { 'id': '08090', 'c': 'green' },
          'd7': { 'id': '08090', 'c': 'green' },
          'd6': { 'id': '08090', 'c': 'green' },
          'd5': { 'id': '08090', 'c': 'green' },
          'd4': { 'id': '08090', 'c': 'green' },
          'd3': { 'id': '08090', 'c': 'green' },
          'd2': { 'id': '08090', 'c': 'green' },
          'd1': { 'id': '08090', 'c': 'red' } },
        { 'C1': 'F3',
          'd43': { 'id': '', 'c': '#aaa' },
          'd42': { 'id': '', 'c': '#aaa' },
          'd41': { 'id': '', 'c': '#aaa' },
          'd40': { 'id': '', 'c': '#aaa' },
          'd39': { 'id': '', 'c': '#aaa' },
          'd38': { 'id': '', 'c': '#aaa' },
          'd37': { 'id': '', 'c': '#aaa' },
          'd36': { 'id': '', 'c': '#aaa' },
          'd35': { 'id': '', 'c': '#aaa' },
          'd34': { 'id': '', 'c': '#aaa' },
          'd33': { 'id': '', 'c': '#aaa' },
          'd32': { 'id': '', 'c': '#aaa' },
          'd31': { 'id': '', 'c': '#aaa' },
          'd30': { 'id': '', 'c': '#aaa' },
          'd29': { 'id': '', 'c': '#aaa' },
          'd28': { 'id': '', 'c': '#aaa' },
          'd27': { 'id': '', 'c': '#aaa' },
          'd26': { 'id': '', 'c': '#aaa' },
          'd25': { 'id': '', 'c': '#aaa' },
          'd24': { 'id': '', 'c': '#aaa' },
          'd23': { 'id': '', 'c': '#aaa' },
          'd22': { 'id': '', 'c': '#aaa' },
          'd21': { 'id': '', 'c': '#aaa' },
          'd20': { 'id': '', 'c': '#aaa' },
          'd19': { 'id': '', 'c': '#aaa' },
          'd18': { 'id': '', 'c': '#aaa' },
          'd17': { 'id': '', 'c': '#aaa' },
          'd16': { 'id': '', 'c': '#aaa' },
          'd15': { 'id': '', 'c': '#aaa' },
          'd14': { 'id': '', 'c': '#aaa' },
          'd13': { 'id': '', 'c': '#aaa' },
          'd12': { 'id': '', 'c': '#aaa' },
          'd11': { 'id': '', 'c': '#aaa' },
          'd10': { 'id': '', 'c': '#aaa' },
          'd9': { 'id': '', 'c': '#aaa' },
          'd8': { 'id': '', 'c': '#aaa' },
          'd7': { 'id': '', 'c': '#aaa' },
          'd6': { 'id': '', 'c': '#aaa' },
          'd5': { 'id': '', 'c': '#aaa' },
          'd4': { 'id': '', 'c': '#aaa' },
          'd3': { 'id': '', 'c': '#aaa' },
          'd2': { 'id': '', 'c': '#aaa' },
          'd1': { 'id': '', 'c': '#aaa' } },
        { 'C1': 'F4',
          'd43': { 'id': '08090', 'c': 'green' },
          'd42': { 'id': '08090', 'c': 'green' },
          'd41': { 'id': '08090', 'c': 'green' },
          'd40': { 'id': '08090', 'c': 'green' },
          'd39': { 'id': '08090', 'c': 'green' },
          'd38': { 'id': '08090', 'c': 'green' },
          'd37': { 'id': '08090', 'c': 'green' },
          'd36': { 'id': '08090', 'c': 'green' },
          'd35': { 'id': '08090', 'c': 'green' },
          'd34': { 'id': '08090', 'c': 'green' },
          'd33': { 'id': '08090', 'c': 'green' },
          'd32': { 'id': '08090', 'c': 'green' },
          'd31': { 'id': '08090', 'c': 'green' },
          'd30': { 'id': '08090', 'c': 'green' },
          'd29': { 'id': '08090', 'c': 'green' },
          'd28': { 'id': '08090', 'c': 'green' },
          'd27': { 'id': '08090', 'c': 'green' },
          'd26': { 'id': '08090', 'c': 'green' },
          'd25': { 'id': '08090', 'c': 'green' },
          'd24': { 'id': '08090', 'c': 'green' },
          'd23': { 'id': '08090', 'c': 'green' },
          'd22': { 'id': '08090', 'c': 'green' },
          'd21': { 'id': '08090', 'c': 'green' },
          'd20': { 'id': '08090', 'c': 'green' },
          'd19': { 'id': '08090', 'c': 'green' },
          'd18': { 'id': '08090', 'c': 'green' },
          'd17': { 'id': '08090', 'c': 'green' },
          'd16': { 'id': '08090', 'c': 'green' },
          'd15': { 'id': '08090', 'c': 'green' },
          'd14': { 'id': '08090', 'c': 'green' },
          'd13': { 'id': '08090', 'c': 'green' },
          'd12': { 'id': '08090', 'c': 'green' },
          'd11': { 'id': '08090', 'c': 'green' },
          'd10': { 'id': '08090', 'c': 'green' },
          'd9': { 'id': '08090', 'c': 'green' },
          'd8': { 'id': '08090', 'c': 'green' },
          'd7': { 'id': '08090', 'c': 'green' },
          'd6': { 'id': '08090', 'c': 'green' },
          'd5': { 'id': '08090', 'c': 'green' },
          'd4': { 'id': '08090', 'c': 'green' },
          'd3': { 'id': '08090', 'c': 'green' },
          'd2': { 'id': '08090', 'c': 'green' },
          'd1': { 'id': '08090', 'c': 'red' } }
      ],
      agingC2: [
        { 'C2': 'F1',
          'd43': { 'id': '08090', 'c': 'orange' },
          'd42': { 'id': '08090', 'c': 'green' },
          'd41': { 'id': '08090', 'c': 'green' },
          'd40': { 'id': '08090', 'c': 'green' },
          'd39': { 'id': '08090', 'c': 'green' },
          'd38': { 'id': '08090', 'c': 'green' },
          'd37': { 'id': '08090', 'c': 'green' },
          'd36': { 'id': '08090', 'c': 'green' },
          'd35': { 'id': '08090', 'c': 'green' },
          'd34': { 'id': '08090', 'c': 'green' },
          'd33': { 'id': '08090', 'c': 'green' },
          'd32': { 'id': '08090', 'c': 'green' },
          'd31': { 'id': '08090', 'c': 'green' },
          'd30': { 'id': '08090', 'c': 'green' },
          'd29': { 'id': '08090', 'c': 'green' },
          'd28': { 'id': '08090', 'c': 'green' },
          'd27': { 'id': '08090', 'c': 'green' },
          'd26': { 'id': '08090', 'c': 'green' },
          'd25': { 'id': '08090', 'c': 'green' },
          'd24': { 'id': '08090', 'c': 'green' },
          'd23': { 'id': '08090', 'c': 'green' },
          'd22': { 'id': '08090', 'c': 'green' },
          'd21': { 'id': '08090', 'c': 'green' },
          'd20': { 'id': '08090', 'c': 'green' },
          'd19': { 'id': '08090', 'c': 'green' },
          'd18': { 'id': '08090', 'c': 'green' },
          'd17': { 'id': '08090', 'c': 'green' },
          'd16': { 'id': '08090', 'c': 'green' },
          'd15': { 'id': '08090', 'c': 'green' },
          'd14': { 'id': '08090', 'c': 'green' },
          'd13': { 'id': '08090', 'c': 'green' },
          'd12': { 'id': '08090', 'c': 'green' },
          'd11': { 'id': '08090', 'c': 'green' },
          'd10': { 'id': '08090', 'c': 'green' },
          'd9': { 'id': '08090', 'c': 'green' },
          'd8': { 'id': '08090', 'c': 'green' },
          'd7': { 'id': '08090', 'c': 'green' },
          'd6': { 'id': '08090', 'c': 'green' },
          'd5': { 'id': '08090', 'c': 'green' },
          'd4': { 'id': '08090', 'c': 'green' },
          'd3': { 'id': '08090', 'c': 'green' },
          'd2': { 'id': '08090', 'c': 'green' },
          'd1': { 'id': '08090', 'c': 'red' } },
        { 'C2': 'F2',
          'd43': { 'id': '08090', 'c': 'green' },
          'd42': { 'id': '08090', 'c': 'green' },
          'd41': { 'id': '08090', 'c': 'green' },
          'd40': { 'id': '08090', 'c': 'green' },
          'd39': { 'id': '08090', 'c': 'green' },
          'd38': { 'id': '08090', 'c': 'green' },
          'd37': { 'id': '08090', 'c': 'green' },
          'd36': { 'id': '08090', 'c': 'green' },
          'd35': { 'id': '08090', 'c': 'green' },
          'd34': { 'id': '08090', 'c': 'green' },
          'd33': { 'id': '08090', 'c': 'green' },
          'd32': { 'id': '08090', 'c': 'green' },
          'd31': { 'id': '08090', 'c': 'green' },
          'd30': { 'id': '08090', 'c': 'green' },
          'd29': { 'id': '08090', 'c': 'green' },
          'd28': { 'id': '08090', 'c': 'green' },
          'd27': { 'id': '08090', 'c': 'green' },
          'd26': { 'id': '08090', 'c': 'green' },
          'd25': { 'id': '08090', 'c': 'green' },
          'd24': { 'id': '08090', 'c': 'green' },
          'd23': { 'id': '08090', 'c': 'green' },
          'd22': { 'id': '08090', 'c': 'green' },
          'd21': { 'id': '08090', 'c': 'green' },
          'd20': { 'id': '08090', 'c': 'green' },
          'd19': { 'id': '08090', 'c': 'green' },
          'd18': { 'id': '08090', 'c': 'green' },
          'd17': { 'id': '08090', 'c': 'green' },
          'd16': { 'id': '08090', 'c': 'green' },
          'd15': { 'id': '08090', 'c': 'green' },
          'd14': { 'id': '08090', 'c': 'green' },
          'd13': { 'id': '08090', 'c': 'green' },
          'd12': { 'id': '08090', 'c': 'green' },
          'd11': { 'id': '08090', 'c': 'green' },
          'd10': { 'id': '08090', 'c': 'green' },
          'd9': { 'id': '08090', 'c': 'green' },
          'd8': { 'id': '08090', 'c': 'green' },
          'd7': { 'id': '08090', 'c': 'green' },
          'd6': { 'id': '08090', 'c': 'green' },
          'd5': { 'id': '08090', 'c': 'green' },
          'd4': { 'id': '08090', 'c': 'green' },
          'd3': { 'id': '08090', 'c': 'green' },
          'd2': { 'id': '08090', 'c': 'green' },
          'd1': { 'id': '08090', 'c': 'red' } },
        { 'C2': 'F3',
          'd43': { 'id': '08090', 'c': 'green' },
          'd42': { 'id': '08090', 'c': 'green' },
          'd41': { 'id': '08090', 'c': 'green' },
          'd40': { 'id': '08090', 'c': 'green' },
          'd39': { 'id': '08090', 'c': 'green' },
          'd38': { 'id': '08090', 'c': 'green' },
          'd37': { 'id': '08090', 'c': 'green' },
          'd36': { 'id': '08090', 'c': 'green' },
          'd35': { 'id': '08090', 'c': 'green' },
          'd34': { 'id': '08090', 'c': 'green' },
          'd33': { 'id': '08090', 'c': 'green' },
          'd32': { 'id': '08090', 'c': 'green' },
          'd31': { 'id': '08090', 'c': 'green' },
          'd30': { 'id': '08090', 'c': 'green' },
          'd29': { 'id': '08090', 'c': 'green' },
          'd28': { 'id': '08090', 'c': 'green' },
          'd27': { 'id': '08090', 'c': 'green' },
          'd26': { 'id': '08090', 'c': 'green' },
          'd25': { 'id': '08090', 'c': 'green' },
          'd24': { 'id': '08090', 'c': 'green' },
          'd23': { 'id': '08090', 'c': 'green' },
          'd22': { 'id': '08090', 'c': 'green' },
          'd21': { 'id': '08090', 'c': 'green' },
          'd20': { 'id': '08090', 'c': 'green' },
          'd19': { 'id': '08090', 'c': 'green' },
          'd18': { 'id': '08090', 'c': 'green' },
          'd17': { 'id': '08090', 'c': 'green' },
          'd16': { 'id': '08090', 'c': 'green' },
          'd15': { 'id': '08090', 'c': 'green' },
          'd14': { 'id': '08090', 'c': 'green' },
          'd13': { 'id': '08090', 'c': 'green' },
          'd12': { 'id': '08090', 'c': 'green' },
          'd11': { 'id': '08090', 'c': 'green' },
          'd10': { 'id': '08090', 'c': 'green' },
          'd9': { 'id': '08090', 'c': 'green' },
          'd8': { 'id': '08090', 'c': 'green' },
          'd7': { 'id': '08090', 'c': 'green' },
          'd6': { 'id': '08090', 'c': 'green' },
          'd5': { 'id': '08090', 'c': 'green' },
          'd4': { 'id': '08090', 'c': 'green' },
          'd3': { 'id': '08090', 'c': 'green' },
          'd2': { 'id': '08090', 'c': 'green' },
          'd1': { 'id': '08090', 'c': 'red' } },
        { 'C2': 'F4',
          'd43': { 'id': '08090', 'c': 'green' },
          'd42': { 'id': '08090', 'c': 'green' },
          'd41': { 'id': '08090', 'c': 'green' },
          'd40': { 'id': '08090', 'c': 'green' },
          'd39': { 'id': '08090', 'c': 'green' },
          'd38': { 'id': '08090', 'c': 'green' },
          'd37': { 'id': '08090', 'c': 'green' },
          'd36': { 'id': '08090', 'c': 'green' },
          'd35': { 'id': '08090', 'c': 'green' },
          'd34': { 'id': '08090', 'c': 'green' },
          'd33': { 'id': '08090', 'c': 'green' },
          'd32': { 'id': '08090', 'c': 'green' },
          'd31': { 'id': '08090', 'c': 'green' },
          'd30': { 'id': '08090', 'c': 'green' },
          'd29': { 'id': '08090', 'c': 'green' },
          'd28': { 'id': '08090', 'c': 'green' },
          'd27': { 'id': '08090', 'c': 'green' },
          'd26': { 'id': '08090', 'c': 'green' },
          'd25': { 'id': '08090', 'c': 'green' },
          'd24': { 'id': '08090', 'c': 'green' },
          'd23': { 'id': '08090', 'c': 'green' },
          'd22': { 'id': '08090', 'c': 'green' },
          'd21': { 'id': '08090', 'c': 'green' },
          'd20': { 'id': '08090', 'c': 'green' },
          'd19': { 'id': '08090', 'c': 'green' },
          'd18': { 'id': '08090', 'c': 'green' },
          'd17': { 'id': '08090', 'c': 'green' },
          'd16': { 'id': '08090', 'c': 'green' },
          'd15': { 'id': '08090', 'c': 'green' },
          'd14': { 'id': '08090', 'c': 'green' },
          'd13': { 'id': '08090', 'c': 'green' },
          'd12': { 'id': '08090', 'c': 'green' },
          'd11': { 'id': '08090', 'c': 'green' },
          'd10': { 'id': '08090', 'c': 'green' },
          'd9': { 'id': '08090', 'c': 'green' },
          'd8': { 'id': '08090', 'c': 'green' },
          'd7': { 'id': '08090', 'c': 'green' },
          'd6': { 'id': '08090', 'c': 'green' },
          'd5': { 'id': '08090', 'c': 'green' },
          'd4': { 'id': '08090', 'c': 'green' },
          'd3': { 'id': '08090', 'c': 'green' },
          'd2': { 'id': '08090', 'c': 'green' },
          'd1': { 'id': '08090', 'c': 'red' } }
      ],
      activeName: '1',
      log: '        container: null,\n' +
        '        camera: null,\n' +
        '        scene: null,\n' +
        '        renderer: null,\n' +
        '        helper: null,\n' +
        '        materials: [],\n' +
        '        meshs: [],\n' +
        '        geometries: [],\n' +
        '        controls: null,\n' +
        '        floorGroup: [],\n' +
        '        width: window.innerWidth - 40,\n' +
        '        height: 300,\n' +
        '        selectedObject: null,\n' +
        '        selectedColor: null,',
      plcConnections: [
        { id: 'assyPLC', name: 'ASSY PLC', con: '#C1232B', time: '0' },
        { id: 'assyTestPLC', name: 'ASSY TEST PLC', con: '#C1232B', time: '0' },
        { id: 'assyAoiPLC', name: 'ASSY AOI PLC', con: '#FCCE10', time: '0.389' },
        { id: 'agPLC', name: 'AG PLC', con: '#B5C334', time: '0.389' },
        { id: 'agTPLC', name: 'AG T PLC', con: '#B5C334', time: '0.389' },
        { id: 'ftPLC', name: 'FT PLC', con: '#B5C334', time: '0.389' },
        { id: 'ftAoi1PLC', name: 'FT AOI1 PLC', con: '#B5C334', time: '0.389' },
        { id: 'ftAoi2PLC', name: 'FT AOI2 PLC', con: '#C1232B', time: '0' }
      ],
      pcConnections: [
        { id: 'ptAoiPC', name: 'PT AOI PC', con: '#C1232B', time: '0' },
        { id: 'fusingPC', name: 'Fusing PC', con: '#C1232B', time: '0' },
        { id: 'assyTestAoi1PC', name: 'ASSY AOI01 PC', con: '#FCCE10', time: '0.389' },
        { id: 'assyTestAoi2PC', name: 'ASSY AOI02 PC', con: '#B5C334', time: '0.389' },
        { id: 'repairPC', name: 'Repair PC', con: '#B5C334', time: '0.389' },
        { id: 'inspPC', name: 'Insp PC', con: '#B5C334', time: '0.389' },
        { id: 'ftAoi1PC', name: 'FT AOI01 PC', con: '#B5C334', time: '0.389' },
        { id: 'ftAoi2PC', name: 'FT AOI02 PC', con: '#C1232B', time: '0' },
        { id: 'ftAoi3PC', name: 'FT AOI03 PC', con: '#B5C334', time: '0.389' },
        { id: 'ftAoi4PC', name: 'FT AOI04 PC', con: '#C1232B', time: '0' },
        { id: 'ft1PC', name: 'FT01 PC', con: '#C1232B', time: '0' },
        { id: 'ft2PC', name: 'FT02 PC', con: '#C1232B', time: '0' },
        { id: 'ft3PC', name: 'FT03 PC', con: '#C1232B', time: '0' },
        { id: 'ft4PC', name: 'FT04 PC', con: '#C1232B', time: '0' },
        { id: 'ft5PC', name: 'FT05 PC', con: '#C1232B', time: '0' },
        { id: 'ft6PC', name: 'FT06 PC', con: '#C1232B', time: '0' },
        { id: 'ft7PC', name: 'FT07 PC', con: '#C1232B', time: '0' },
        { id: 'ft8PC', name: 'FT08 PC', con: '#C1232B', time: '0' }
      ],
      alarmList: [
        { id: '2342', unit: 'Fusing', desc: 'In div up over time', start: '2018-09-09 09:10:10', end: '2018-09-09 09:11:10' },
        { id: '2342', unit: 'Fusing', desc: 'In div up over time', start: '2018-09-09 09:10:10', end: '2018-09-09 09:11:10' },
        { id: '2342', unit: 'Fusing', desc: 'In div up over time', start: '2018-09-09 09:10:10', end: '2018-09-09 09:11:10' },
        { id: '2342', unit: 'Fusing', desc: 'In div up over time', start: '2018-09-09 09:10:10', end: '2018-09-09 09:11:10' },
        { id: '2342', unit: 'Fusing', desc: 'In div up over time', start: '2018-09-09 09:10:10', end: '2018-09-09 09:11:10' }
      ],
      temperatureOption: {
        title: {
          x: 'center',
          text: '实时温度'
          // subtext: 'Rainbow bar example',
          // link: 'http://echarts.baidu.com/doc/example.html'
        },
        tooltip: {
          trigger: 'axis'
        },
        legend: {
          data: ['AG', 'CL'],
          x: 'right'
        },
        // calculable : true,
        xAxis: [
          {
            type: 'category',
            boundaryGap: false,
            data: ['AVG', 'CH1', 'CH2', 'CH3', 'CH4', 'CH5', 'CH6', 'CH7', 'CH8', 'CH9', 'CH10', 'CH11', 'CH12'],
            axisLabel: {
              interval: 0,
              rotate: 40
            }
          }
        ],
        yAxis: [
          {
            type: 'value',
            show: false,
            axisLabel: {
              color: 'black',
              fontSize: 12
            }
          }
        ],
        series: [
          {
            name: 'AG',
            type: 'line',
            // stack: '温度',
            data: [50, 50, 49, 48, 54, 43, 54, 50, 50, 49, 48, 54, 54],
            itemStyle: {
              normal: {
                label: {
                  show: true,
                  formatter: '{c}'
                }
              }
            }
          },
          {
            name: 'CL',
            type: 'line',
            // stack: '温度',
            data: [23, 22, 12],
            itemStyle: {
              normal: {
                label: {
                  show: true,
                  formatter: '{c}'
                }
              }
            }
          }
        ]
      },
      capacityOption: {
        title: {
          x: 'center',
          text: '产量统计'
          // subtext: 'Rainbow bar example',
          // link: 'http://echarts.baidu.com/doc/example.html'
        },
        tooltip: {
          trigger: 'item'
        },
        // toolbox: {
        //   show: true,
        //   feature: {
        //     dataView: {show: true, readOnly: false},
        //     restore: {show: true},
        //     saveAsImage: {show: true}
        //   }
        // },
        calculable: true,
        grid: {
          borderWidth: 0,
          y: 80,
          y2: 60
        },
        xAxis: [
          {
            type: 'category',
            show: false,
            data: ['CLASS A', 'CLASS B', 'TOTAL']
          }
        ],
        yAxis: [
          {
            type: 'value',
            show: false
          }
        ],
        series: [
          {
            name: '产量统计',
            type: 'bar',
            itemStyle: {
              normal: {
                color: function (params) {
                  // build a color map as your need.
                  var colorList = [
                    '#C1232B', '#B5C334', '#FCCE10', '#E87C25', '#27727B',
                    '#FE8463', '#9BCA63', '#FAD860', '#F3A43B', '#60C0DD',
                    '#D7504B', '#C6E579', '#F4E001', '#F0805A', '#26C0C0'
                  ]
                  return colorList[params.dataIndex]
                },
                label: {
                  show: true,
                  position: 'top',
                  formatter: '{b}\n{c}'
                }
              }
            },
            data: [1122, 1221, 2343]
          }
        ]
      },
      tactTimeOption: {
        title: {
          x: 'center',
          text: '节拍统计'
        },
        tooltip: {
          trigger: 'axis'
        },
        // legend: {
        //   data:['AG','CL'],
        //   x: 'right'
        // },
        // calculable : true,
        xAxis: [
          {
            type: 'category',
            boundaryGap: false,
            data: ['ASSY', 'Fusing', 'AOI', 'Aging In', 'Aging Out', 'Aging Insp', 'AOI01', 'AOI02', 'FT'],
            axisLabel: {
              interval: 0,
              rotate: 40
            }
          }
        ],
        yAxis: [
          {
            type: 'value',
            show: false,
            // 或者
            axisLabel: {
              color: 'black',
              fontSize: 12,
              formatter: function (v) {
                return v.toFixed(1) // 0表示小数为0位，1表示1位小数，2表示2位小数
              }
            }
          }
        ],
        series: [
          {
            name: 'AG',
            type: 'line',
            data: [5.0, 5.0, 4.9, 4.8, 5.4, 4.3, 5.4, 5.0, 5.0],
            itemStyle: {
              normal: {
                label: {
                  show: true,
                  // formatter: '{c}'
                  formatter: function (value) {
                    return value.data.toFixed(1) // 0表示小数为0位，1表示1位小数，2表示2位小数
                  }
                }
              }
            }
          }
        ]
      },
      counterOption: {
        title: {
          x: 'center',
          text: '个数统计'
        },
        tooltip: {
          trigger: 'axis',
          axisPointer: { // 坐标轴指示器，坐标轴触发有效
            type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
          },
          extraCssText: 'z-index: 10000;',
          position: function (point, params, dom, rect, size) { // point: 鼠标位置
            var tipHeight = point[1] + size.contentSize[1] // contentSize: 提示dom 窗口大小
            if (tipHeight > size.viewSize[1]) { // viewSize: echarts 容器大小
              return [point[0], point[1] - size.contentSize[1] + 80]
            } else if (point[1] < size.contentSize[1]) {
              return [point[0] + 40, point[1] + 20]
            } else {
              return point
            }
          }
        },
        legend: {
          data: ['Total Panels', 'Aging Panels', 'Total Pallets', 'Aging Pallets', 'Process Pallets', 'Completed Pallets', 'Overtime Pallets', 'Empty Pallets'],
          type: 'scroll',
          // orient: 'vertical'
          top: 'bottom'
        },
        calculable: true,
        xAxis: [
          {
            type: 'category',
            data: ['Panels and Pallets']
          }
        ],
        yAxis: [
          {
            type: 'value',
            show: false
          }
        ],
        series: [
          {
            name: 'Total Panels',
            type: 'bar',
            data: [520]
          },
          {
            name: 'Aging Panels',
            type: 'bar',
            data: [120]
          },
          {
            name: 'Total Pallets',
            type: 'bar',
            data: [420]
          },
          {
            name: 'Aging Pallets',
            type: 'bar',
            data: [250]
          },
          {
            name: 'Process Pallets',
            type: 'bar',
            stack: 'aging',
            data: [80]
          },
          {
            name: 'Completed Pallets',
            type: 'bar',
            stack: 'aging',
            data: [60]
          },
          {
            name: 'Overtime Pallets',
            type: 'bar',
            stack: 'aging',
            data: [80]
          },
          {
            name: 'Empty Pallets',
            type: 'bar',
            stack: 'aging',
            data: [30]
          }
        ]
      },
      machineStateOption: {
        title: {
          x: 'left',
          text: '运行状态'
        },
        // tooltip: {
        //   trigger: 'axis',
        //   axisPointer: { // 坐标轴指示器，坐标轴触发有效
        //     type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
        //   },
        //   position: function (point, params, dom, rect, size) { // point: 鼠标位置
        //     var tipHeight = point[1] + size.contentSize[1] // contentSize: 提示dom 窗口大小
        //     if (tipHeight > size.viewSize[1]) { // viewSize: echarts 容器大小
        //       return [point[0] - 10, point[1] - size.contentSize[1] + 50]
        //     } else if (point[1] < size.contentSize[1]) {
        //       return [point[0] + 40, point[1] + 20]
        //     } else {
        //       return point
        //     }
        //   }
        // },
        legend: {
          data: ['idle', 'run', 'down', 'pm'],
          type: 'scroll',
          // orient: 'vertical'
          left: 'right'
        },
        // toolbox: {
        //     show : true,
        //     feature : {
        //         mark : {show: true},
        //         dataView : {show: true, readOnly: false},
        //         magicType : {show: true, type: ['line', 'bar', 'stack', 'tiled']},
        //         restore : {show: true},
        //         saveAsImage : {show: true}
        //     }
        // },
        calculable: true,
        xAxis: [
          {
            type: 'category',
            data: ['Assy', 'Fusing', 'AOI', 'Aging', 'Aging Insp', 'AOI01', 'AOI02'],
            //, 'FT01','FT02','FT03','FT04','FT05','FT06','FT07','FT08','FT09','FT10'
            axisLabel: {
              interval: 0,
              rotate: 40
            }
          }
        ],
        yAxis: [
          {
            type: 'value',
            show: false
          }
        ],
        series: [
          {
            name: 'idle',
            type: 'bar',
            stack: 'state',
            data: [1, 0, 0, 1, 0, 1, 0]
          },
          {
            name: 'run',
            type: 'bar',
            stack: 'state',
            data: [0, 0, 1, 0, 0, 0, 0]
          },
          {
            name: 'down',
            type: 'bar',
            stack: 'state',
            data: [0, 0, 0, 0, 0, 0, 1]
          },
          {
            name: 'pm',
            type: 'bar',
            stack: 'state',
            data: [0, 1, 0, 0, 1, 0, 0]
          }
        ]
      }
    }
  },
  watch: {
    data: {
      handler: function (newValue, oldValue) {
        for (let a = 0; a < newValue.length; a++) {
          for (let b = 0; b < newValue[a].length; b++) {
            for (let c = 0; c < newValue[a][b].length; c++) {
              // if(newValue[a][b][c].id !== this.oldData[a][b][c].id){
              //   console.log(newValue[a][b][c].id)
              //   var POSITION = {x:0, y:0, z:0}
              //   POSITION.y = 3+a*10;
              //   POSITION.z = (b+1)*10 - 5;
              //   POSITION.x = (c+1)*10 - 5;
              //
              //   if(newValue[a][b][c].id === "") {
              //     // this.pallet[a][b][c].p.position.x = POSITION.x;
              //     // this.pallet[a][b][c].p.position.y = POSITION.y;
              //     // this.pallet[a][b][c].p.position.z = POSITION.z;
              //     // this.pallet[a][b][c].p.visible = true
              //     // var that = this
              //     // new TWEEN.Tween(this.pallet[a][b][c].p.position).to( {x: POSITION.x+newValue[a][b][c].x*5*newValue[a][b][c].m,
              //     //   y: POSITION.y+newValue[a][b][c].y*5*newValue[a][b][c].m, z: POSITION.z+newValue[a][b][c].z*5*newValue[a][b][c].m}, 1000).onComplete(function () {
              //     //   that.pallet[a][b][c].p.visible = false;
              //     // }).start();
              //   }else {
              //     // var materials = [
              //     //   new THREE.MeshBasicMaterial( { color: 'blue' } ), // right
              //     //   new THREE.MeshBasicMaterial( { color: 'yellow' } ), // left
              //     //   new THREE.MeshBasicMaterial( { map: new THREE.CanvasTexture(this.getTextCanvas(newValue[a][b][c].id)) } ), // top
              //     //   new THREE.MeshBasicMaterial( { color: 'black' } ), // bottom
              //     //   new THREE.MeshBasicMaterial( { color: 'green' } ), // back
              //     //   new THREE.MeshBasicMaterial( { color: 'red' } ) // front
              //     // ];
              //     // this.pallet[a][b][c].p.material = materials;
              //     // // this.pallet[a][b][c].p.position.x = POSITION.x+newValue[a][b][c].x*5*newValue[a][b][c].m;
              //     // // this.pallet[a][b][c].p.position.y = POSITION.y+newValue[a][b][c].y*5*newValue[a][b][c].m;
              //     // // this.pallet[a][b][c].p.position.z = POSITION.z+newValue[a][b][c].z*5*newValue[a][b][c].m;
              //     // this.pallet[a][b][c].p.position.x = POSITION.x;
              //     // this.pallet[a][b][c].p.position.y = POSITION.y;
              //     // this.pallet[a][b][c].p.position.z = POSITION.z;
              //     // this.pallet[a][b][c].p.visible = true
              //     // // var that = this
              //     // // new TWEEN.Tween(this.pallet[a][b][c].p.position).to( {x: POSITION.x, y: POSITION.y, z: POSITION.z}, 1000).onStart(function () {
              //     // //   that.pallet[a][b][c].p.visible = true;
              //     // // }).start();
              //   }
              // }

              if (newValue[a][b][c].id !== undefined && newValue[a][b][c].id !== '' && this.pallet[a][b][c].p === null &&
                  newValue[a][b][c].id !== this.oldData[a][b][c].id) {
                let POSITION = { x: 0, y: 0, z: 0 }
                POSITION.y = 3 + a * 10
                POSITION.z = (b + 1) * 10 - 5
                POSITION.x = (c + 1) * 10 - 5
                this.addPallet(a, b, c, newValue[a][b][c], 0, POSITION)
              }

              if (newValue[a][b][c].id === '' && this.pallet[a][b][c].p !== null && this.pallet[a][b][c].p !== undefined &&
                  newValue[a][b][c].id !== this.oldData[a][b][c].id) {
                this.dec(0, this.pallet[a][b][c].p)
                this.pallet[a][b][c].p = null
              }

              if (newValue[a][b][c].o !== this.oldData[a][b][c].o) {
                if (newValue[a][b][c].o === 1) {
                  let POSITION = { x: 0, y: 0, z: 0 }
                  POSITION.y = 3 + a * 10
                  POSITION.z = (b + 1) * 10 - 5
                  POSITION.x = (c + 1) * 10 - 5
                  this.pallet[a][b][c].p.position.x = POSITION.x
                  this.pallet[a][b][c].p.position.y = POSITION.y
                  this.pallet[a][b][c].p.position.z = POSITION.z
                  this.pallet[a][b][c].p.visible = true
                  var that = this
                  new TWEEN.Tween(this.pallet[a][b][c].p.position).to({ x: POSITION.x + newValue[a][b][c].x * 10 * newValue[a][b][c].m,
                    y: POSITION.y + newValue[a][b][c].y * 10 * newValue[a][b][c].m,
                    z: POSITION.z + newValue[a][b][c].z * 10 * newValue[a][b][c].m }, 1000 * newValue[a][b][c].m).onComplete(function () {
                    // // that.pallet[a][b][c].p.visible = false;
                    //
                    // var POSITION = {x:0, y:0, z:0}
                    // POSITION.y = 3+a*10;
                    // POSITION.z = (b+1)*10 - 5;
                    // POSITION.x = (c+1)*10 - 5;
                    // var m= (POSITION.y+newValue[a][b][c].y*10*newValue[a][b][c].m-3)/10;
                    // var n= (5+POSITION.z+newValue[a][b][c].z*10*newValue[a][b][c].m)/10-1;
                    // var s= (5+POSITION.x+newValue[a][b][c].x*10*newValue[a][b][c].m)/10-1;
                    // // var materials = [
                    // //   new THREE.MeshBasicMaterial( { color: 'blue' } ), // right
                    // //   new THREE.MeshBasicMaterial( { color: 'yellow' } ), // left
                    // //   new THREE.MeshBasicMaterial( { map: new THREE.CanvasTexture(that.getTextCanvas(newValue[a][b][c].id)) } ), // top
                    // //   new THREE.MeshBasicMaterial( { color: 'black' } ), // bottom
                    // //   new THREE.MeshBasicMaterial( { color: 'green' } ), // back
                    // //   new THREE.MeshBasicMaterial( { color: 'red' } ) // front
                    // // ];
                    // // that.pallet[m][n][s].p.material = materials;
                    // // that.pallet[m][n][s].p.data.id = newValue[a][b][c].id;
                    // // that.data[m][n][s].id = newValue[a][b][c].id;
                    // that.pallet[m][n][s].p = that.pallet[a][b][c].p;
                    // that.pallet[a][b][c].p = null;
                    // // // this.pallet[a][b][c].p.position.x = POSITION.x+newValue[a][b][c].x*5*newValue[a][b][c].m;
                    // // // this.pallet[a][b][c].p.position.y = POSITION.y+newValue[a][b][c].y*5*newValue[a][b][c].m;
                    // // // this.pallet[a][b][c].p.position.z = POSITION.z+newValue[a][b][c].z*5*newValue[a][b][c].m;
                    // // that.pallet[m][n][s].p.position.x = (s+1)*10 - 5;
                    // // that.pallet[m][n][s].p.position.y = 3+m*10;
                    // // that.pallet[m][n][s].p.position.z = (n+1)*10 - 5;
                    // // that.pallet[m][n][s].p.visible = true

                  }).onStart(function () {
                    let POSITION = { x: 0, y: 0, z: 0 }
                    POSITION.y = 3 + a * 10
                    POSITION.z = (b + 1) * 10 - 5
                    POSITION.x = (c + 1) * 10 - 5

                    var m = (POSITION.y + newValue[a][b][c].y * 10 * newValue[a][b][c].m - 3) / 10
                    var n = (5 + POSITION.z + newValue[a][b][c].z * 10 * newValue[a][b][c].m) / 10 - 1
                    var s = (5 + POSITION.x + newValue[a][b][c].x * 10 * newValue[a][b][c].m) / 10 - 1

                    if (a === 3 && b === 14 && c === 15) {
                      console.log('haha')
                      console.log('haha')
                      console.log('haha')
                      console.log('haha')
                    }

                    that.pallet[m][n][s].p = that.pallet[a][b][c].p
                    that.pallet[a][b][c].p = null
                  }).start()
                }
              }

              if (newValue[a][b][c].id !== this.oldData[a][b][c].id) {
                // console.log(this.oldData[a][b][c].id)
                // console.log('-----------------')
                if (a === 0 && b === 3 && c <= 58 && c >= 16) {
                  let d = 'd' + (43 - (c - 15) + 1)
                  this.agingC2[0][d].id = newValue[a][b][c].id
                } else if (a === 1 && b === 3 && c <= 58 && c >= 16) {
                  let d = 'd' + (43 - (c - 15) + 1)
                  this.agingC2[1][d].id = newValue[a][b][c].id
                } else if (a === 2 && b === 3 && c <= 58 && c >= 16) {
                  let d = 'd' + (43 - (c - 15) + 1)
                  this.agingC2[2][d].id = newValue[a][b][c].id
                } else if (a === 3 && b === 3 && c <= 58 && c >= 16) {
                  let d = 'd' + (43 - (c - 15) + 1)
                  this.agingC2[3][d].id = newValue[a][b][c].id
                } else if (a === 0 && b === 4 && c <= 58 && c >= 16) {
                  let d = 'd' + (43 - (c - 15) + 1)
                  this.agingC1[0][d].id = newValue[a][b][c].id
                } else if (a === 1 && b === 4 && c <= 58 && c >= 16) {
                  let d = 'd' + (43 - (c - 15) + 1)
                  this.agingC1[1][d].id = newValue[a][b][c].id
                } else if (a === 2 && b === 4 && c <= 58 && c >= 16) {
                  let d = 'd' + (43 - (c - 15) + 1)
                  this.agingC1[2][d].id = newValue[a][b][c].id
                  console.log('-----------------')
                  console.log(this.agingC1[2][d].id)
                  console.log('-----------------')
                } else if (a === 3 && b === 4 && c <= 58 && c >= 16) {
                  let d = 'd' + (43 - (c - 15) + 1)
                  this.agingC1[3][d].id = newValue[a][b][c].id
                }
              }
            }
          }
        }
        this.oldData = JSON.parse(JSON.stringify(newValue))
      },
      deep: true
    },
    alarmList: function (newValue, oldValue) {
      // this.SETALARMCOUNT(newValue.length)
    }
  },
  computed: {

  },
  methods: {
    ...mapMutations([
      // 'SETALARMCOUNT'
    ]),
    palletColor: function (row, index) {
      let id = 'd' + index
      return row[id]
    },
    stateId: function (row, index) {
      let id = 'd' + index
      return row[id].id
    },
    stateColor: function (row, index) {
      let id = 'd' + index
      return row[id].c
    },
    onFocus: function () {
      var pFocus
      pFocus = document.getElementById('pallet-id')
      pFocus.focus()
      // pFocus.select();
    },
    remoteStart: function () {
      this.api({
        url: '/simulate/start',
        method: 'post'
      }).then(() => {

      })
    },
    start: function () {
      if (this.stop) {
        this.stop = false
        this.startLabel = 'start'
        // this.floorGroup[0].panel[0].inT.start()
      } else {
        this.stop = true
        this.startLabel = 'stop'
        // this.floorGroup[0].panel[0].outT.start()
      }

      this.$set(this.data[0][1][0], 'o', 1)
      this.$set(this.data[0][1][0], 'z', 1)

      this.$set(this.data[0][2][2], 'o', 1)
      this.$set(this.data[0][2][2], 'x', 1)

      this.$set(this.data[0][2][7], 'o', 1)
      this.$set(this.data[0][2][7], 'z', 1)
      this.$set(this.data[0][2][7], 'm', 3)

      // this.$set(this.data[3][4][15],"o", 1)
      // this.$set(this.data[3][4][15],"x", 1)
      // this.$set(this.data[3][4][15],"m", 43)

      // this.$set(this.data[3][4][15], 'o', 1)
      // this.$set(this.data[3][4][15], 'z', -1)
      // this.$set(this.data[3][4][15], 'y', -1)
      var that = this
      setTimeout(function () {
        // that.$set(that.data[0][2][0],"id", "08093")
        // that.pallet[0][2][0].p.data.id = "08093"
        // that.$set(that.data[0][2][3],"id", "08095")
        // that.pallet[0][2][3].p.data.id = "08095"

        that.$set(that.data[0][1][0], 'o', 0)
        // that.$set(that.data[0][1][0],"z", 0)

        that.$set(that.data[0][2][2], 'o', 0)
        // that.$set(that.data[0][2][2],"x", 0)

        that.$set(that.data[0][0][0], 'o', 1)
        that.$set(that.data[0][0][0], 'z', 1)

        that.$set(that.data[0][2][1], 'o', 1)
        that.$set(that.data[0][2][1], 'x', 1)

        // that.$set(that.data[3][4][14],"o", 1)
        // that.$set(that.data[3][4][14],"x", 1)
        //
        // that.$set(that.data[3][4][15],"o", 0)
      }, 1100)

      setTimeout(function () {
        // that.$set(that.data[0][1][0],"id", "08090")
        // that.pallet[0][1][0].p.data.id = "08090"
        // that.$set(that.data[0][2][2],"id", "08094")
        // that.pallet[0][2][2].p.data.id = "08094"

        that.$set(that.data[0][0][0], 'o', 0)
        // that.$set(that.data[0][0][0],"z", 0)

        // that.$set(that.data[0][2][1],"o", 0)
        // that.$set(that.data[0][2][1],"x", 0)

        that.$set(that.data[0][0][1], 'o', 1)
        that.$set(that.data[0][0][1], 'x', -1)

        that.$set(that.data[0][2][0], 'o', 1)
        that.$set(that.data[0][2][0], 'x', 1)

        that.$set(that.data[0][2][3], 'o', 1)
        that.$set(that.data[0][2][3], 'x', 1)

        // that.$set(that.data[3][4][13],"o", 1)
        // that.$set(that.data[3][4][13],"x", 1)
        //
        // that.$set(that.data[3][4][15],"o", 1)
        // that.$set(that.data[3][4][15],"x", 1)
        // that.$set(that.data[3][4][15],"m", 42)
        //
        // that.$set(that.data[3][4][14],"o", 0)

        // that.$set(that.data[2][3][15], 'o', 1)
        // that.$set(that.data[2][3][15], 'x', 1)
        // that.$set(that.data[2][3][15], 'm', 43)
      }, 2100)

      setTimeout(function () {
        // that.$set(that.data[0][0][0],"id", "08091")
        // that.pallet[0][0][0].p.data.id = "08091"
        // that.$set(that.data[0][2][1],"id", "08093")
        // that.pallet[0][2][1].p.data.id = "08093"
        // that.$set(that.data[0][2][4],"id", "08095")
        // that.pallet[0][2][4].p.data.id = "08095"
        //
        // that.$set(that.data[0][5][7],"id", "08096")
        // that.pallet[0][5][7].p.data.id = "08096"
        //
        that.$set(that.data[0][0][1], 'o', 0)
        // that.$set(that.data[0][0][1],"x", 0)
        //
        that.$set(that.data[0][2][0], 'o', 0)
        // that.$set(that.data[0][2][0],"x", 0)
        //
        that.$set(that.data[0][2][3], 'o', 0)
        // that.$set(that.data[0][2][3],"x", 0)

        // that.$set(that.data[0][0][2],"o", 1)
        // that.$set(that.data[0][0][2],"x", -1)
        //
        // that.$set(that.data[0][1][0],"o", 1)
        // that.$set(that.data[0][1][0],"z", 1)

        // that.$set(that.data[3][4][14],"o", 1)
        // that.$set(that.data[3][4][14],"x", 1)
        //
        // that.$set(that.data[3][4][15],"o", 0)
      }, 3100)

      setTimeout(function () {
        // that.$set(that.data[0][0][1],"id", "08092")
        // that.pallet[0][0][1].p.data.id = "08092"
        // that.$set(that.data[0][2][0],"id", "08090")
        // that.pallet[0][2][0].p.data.id = "08090"

        that.$set(that.data[0][0][2], 'o', 0)
        // that.$set(that.data[0][0][2],"x", 0)
        //
        that.$set(that.data[0][1][0], 'o', 0)
        // that.$set(that.data[0][1][0],"z", 0)
      }, 4100)
    },
    init: function () {
      this.scene = new THREE.Scene()

      this.container = document.getElementById('container')
      this.renderer = new THREE.WebGLRenderer({ antialias: true })
      this.renderer.setSize(this.width, this.height)
      this.renderer.setClearColor(0xffffff)
      this.container.appendChild(this.renderer.domElement)

      this.camera = new THREE.PerspectiveCamera(30, this.width / this.height, 1, 1000)
      // this.camera = new THREE.OrthographicCamera( this.width / - 2, this.width / 2, this.height / 2, this.height / - 2, 1, 1000 );
      this.camera.position.set(0, 370, 300)
      // this.camera.lookAt(new THREE.Vector3(0, 0, 0));
      this.camera.lookAt(this.scene.position)
      this.scene.add(this.camera)

      this.controls = new TrackballControls(this.camera, this.renderer.domElement)
      this.controls.rotateSpeed = 5.0
      this.controls.zoomSpeed = 5
      this.controls.panSpeed = 2
      this.controls.noZoom = false
      this.controls.noPan = false
      this.controls.staticMoving = true
      this.controls.dynamicDampingFactor = 0.3

      // // controls
      // this.controls = new OrbitControls( this.camera, this.renderer.domElement );
      // //controls.addEventListener( 'change', render ); // call this only in static scenes (i.e., if there is no animation loop)
      // // this.controls.enableDamping = true; // an animation loop is required when either damping or auto-rotation are enabled
      // // this.controls.dampingFactor = 0.25;
      // // this.controls.screenSpacePanning = false;
      // // this.controls.minDistance = 0;
      // // this.controls.maxDistance = 600;
      // // this.controls.maxPolarAngle = Math.PI / 1;

      var group1 = new THREE.Group()
      group1.panel = []
      group1.position.x = -590
      group1.position.z = -30
      group1.scale.z = 1.3
      this.floorGroup.push(group1)
      // this.scene.add(this.floorGroup);

      // var helper = new THREE.GridHelper( 2000, 2000 , 0x0000ff, 0x808080);
      // this.scene.add( helper );

      var LOADTR = [
        [0, 0, 0],
        [0, 0, 30],
        [10, 0, 30],
        [10, 0, 0]
      ]
      var MODE_CHANGE = [
        [10, 0, 0],
        [10, 0, 10],
        [30, 0, 10],
        [30, 0, 0]
      ]
      var RETURN_LF = [
        [30, 0, 0],
        [30, 0, 10],
        [40, 0, 10],
        [40, 0, 0]
      ]
      var LOAD = [
        [10, 0, 30],
        [30, 0, 30],
        [30, 0, 20],
        [10, 0, 20]
      ]
      var WIRE = [
        [30, 0, 30],
        [50, 0, 30],
        [50, 0, 20],
        [30, 0, 20]
      ]
      var FUSING_TR = [
        [50, 0, 30],
        [70, 0, 30],
        [70, 0, 20],
        [50, 0, 20]
      ]
      var FUSING = [
        [70, 0, 20],
        [70, 0, 60],
        [80, 0, 60],
        [80, 0, 20]
      ]
      var AT01 = [
        [80, 0, 30],
        [80, 0, 60],
        [90, 0, 60],
        [90, 0, 30]
      ]
      var AT02 = [
        [90, 0, 30],
        [90, 0, 60],
        [100, 0, 60],
        [100, 0, 30]
      ]
      var REP_BUF = [
        [100, 0, 0],
        [100, 0, 50],
        [110, 0, 50],
        [110, 0, 0]
      ]
      var REP = [
        [110, 0, 0],
        [110, 0, 50],
        [120, 0, 50],
        [120, 0, 0]
      ]
      var IN_BRIDGE_LF = [
        [120, 0, 40],
        [120, 0, 50],
        [130, 0, 50],
        [130, 0, 40]
      ]
      var GATE_WAY = [
        [130, 30, 40],
        [130, 30, 50],
        [140, 30, 50],
        [140, 30, 40]
      ]
      var TURN = [
        [140, 30, 40],
        [140, 30, 50],
        [150, 30, 50],
        [150, 30, 40]
      ]
      var AG_IN_LF = [
        [150, 0, 30],
        [150, 0, 50],
        [160, 0, 50],
        [160, 0, 30]
      ]
      var AG_RM_1_1 = [
        [160, 0, 40],
        [160, 0, 50],
        [590, 0, 50],
        [590, 0, 40]
      ]
      var AG_RM_1_2 = [
        [160, 10, 40],
        [160, 10, 50],
        [590, 10, 50],
        [590, 10, 40]
      ]
      var AG_RM_1_3 = [
        [160, 20, 40],
        [160, 20, 50],
        [590, 20, 50],
        [590, 20, 40]
      ]
      var AG_RM_1_4 = [
        [160, 30, 40],
        [160, 30, 50],
        [590, 30, 50],
        [590, 30, 40]
      ]
      var AG_RM_2_1 = [
        [160, 0, 30],
        [160, 0, 40],
        [590, 0, 40],
        [590, 0, 30]
      ]
      var AG_RM_2_2 = [
        [160, 10, 30],
        [160, 10, 40],
        [590, 10, 40],
        [590, 10, 30]
      ]
      var AG_RM_2_3 = [
        [160, 20, 30],
        [160, 20, 40],
        [590, 20, 40],
        [590, 20, 30]
      ]
      var AG_RM_2_4 = [
        [160, 30, 30],
        [160, 30, 40],
        [590, 30, 40],
        [590, 30, 30]
      ]
      var AG_OUT_LF = [
        [590, 0, 30],
        [590, 0, 50],
        [600, 0, 50],
        [600, 0, 30]
      ]
      var INSP = [
        [600, 0, 30],
        [600, 0, 40],
        [610, 0, 40],
        [610, 0, 50],
        [620, 0, 50],
        [620, 0, 40],
        [630, 0, 40],
        [630, 0, 30]
      ]
      var CL_1 = [
        [630, 0, 30],
        [630, 0, 40],
        [890, 0, 40],
        [890, 0, 30]
      ]
      var CL_2 = [
        [630, 0, 40],
        [630, 0, 50],
        [890, 0, 50],
        [890, 0, 40]
      ]
      var CL_OUT = [
        [890, 0, 30],
        [890, 0, 40],
        [900, 0, 40],
        [900, 0, 30]
      ]
      var CL_OUT_LF = [
        [900, 0, 30],
        [900, 0, 40],
        [910, 0, 40],
        [910, 0, 30]
      ]
      var CL_OUT_RT = [
        [910, 30, 0],
        [910, 30, 40],
        [930, 30, 40],
        [930, 30, 30],
        [920, 30, 30],
        [920, 30, 0]
      ]
      var AG_CL_RT = [
        [40, 30, 0],
        [40, 30, 10],
        [910, 30, 10],
        [910, 30, 0]
      ]
      var FT_IN_LF = [
        [930, 0, 30],
        [930, 0, 40],
        [940, 0, 40],
        [940, 0, 30]
      ]
      var FI_IN_TR = [
        [940, 0, 30],
        [940, 0, 50],
        [950, 0, 50],
        [950, 0, 30]
      ]
      var FI_1 = [
        [950, 0, 20],
        [950, 0, 50],
        [960, 0, 50],
        [960, 0, 20]
      ]
      var FI_2 = [
        [960, 0, 20],
        [960, 0, 50],
        [970, 0, 50],
        [970, 0, 20]
      ]
      var FI_TR_1 = [
        [970, 0, 30],
        [970, 0, 40],
        [990, 0, 40],
        [990, 0, 30]
      ]
      var FI_TR_2 = [
        [970, 0, 40],
        [970, 0, 50],
        [990, 0, 50],
        [990, 0, 40]
      ]
      var FI_3 = [
        [990, 0, 20],
        [990, 0, 50],
        [1000, 0, 50],
        [1000, 0, 20]
      ]
      var FI_4 = [
        [1000, 0, 20],
        [1000, 0, 50],
        [1010, 0, 50],
        [1010, 0, 20]
      ]
      var FT_IN_TR = [
        [1010, 0, 10],
        [1010, 0, 40],
        [1020, 0, 40],
        [1020, 0, 10]
      ]
      var FT_1 = [
        [1020, 0, 10],
        [1020, 0, 40],
        [1030, 0, 40],
        [1030, 0, 10]
      ]
      var FT_2 = [
        [1030, 0, 10],
        [1030, 0, 40],
        [1040, 0, 40],
        [1040, 0, 10]
      ]
      var FT_3 = [
        [1040, 0, 10],
        [1040, 0, 40],
        [1050, 0, 40],
        [1050, 0, 10]
      ]
      var FT_4 = [
        [1050, 0, 10],
        [1050, 0, 40],
        [1060, 0, 40],
        [1060, 0, 10]
      ]
      var FT_5 = [
        [1060, 0, 0],
        [1060, 0, 30],
        [1070, 0, 30],
        [1070, 0, 0]
      ]
      var FT_6 = [
        [1070, 0, 0],
        [1070, 0, 30],
        [1080, 0, 30],
        [1080, 0, 0]
      ]
      var FT_7 = [
        [1080, 0, 0],
        [1080, 0, 30],
        [1090, 0, 30],
        [1090, 0, 0]
      ]
      var FT_8 = [
        [1090, 0, 0],
        [1090, 0, 30],
        [1100, 0, 30],
        [1100, 0, 0]
      ]
      var LOAD_OUT = [
        [1100, 0, 20],
        [1100, 0, 30],
        [1130, 0, 30],
        [1130, 0, 20]
      ]
      var LOAD_OUT_LF = [
        [1130, 0, 20],
        [1130, 0, 30],
        [1140, 0, 30],
        [1140, 0, 20]
      ]
      var FT_RT = [
        [920, 30, 20],
        [920, 30, 30],
        [1130, 30, 30],
        [1130, 30, 20]
      ]

      var drawFactory = function (that, group) {
        that.floorGeometry(group, 'LOADTR', LOADTR, 2)
        that.floorGeometry(group, 'MODE_CHANGE', MODE_CHANGE, 2)
        that.floorGeometry(group, 'RETURN_LF', RETURN_LF, 32)
        that.floorGeometry(group, 'LOAD', LOAD, 2)
        that.floorGeometry(group, 'WIRE', WIRE, 2)
        that.floorGeometry(group, 'FUSING_TR', FUSING_TR, 2)
        that.floorGeometry(group, 'FUSING', FUSING, 2)
        that.floorGeometry(group, 'AT01', AT01, 2)
        that.borderXdraw(group, [
          [80, 0, 30],
          [80, 0, 40],
          [90, 0, 40],
          [90, 0, 30]
        ], 2)
        that.borderXdraw(group, [
          [80, 0, 40],
          [80, 0, 50],
          [90, 0, 50],
          [90, 0, 40]
        ], 2)
        that.borderXdraw(group, [
          [80, 0, 50],
          [80, 0, 60],
          [90, 0, 60],
          [90, 0, 50]
        ], 2)
        that.floorGeometry(group, 'AT02', AT02, 2)
        that.borderXdraw(group, [
          [90, 0, 30],
          [90, 0, 40],
          [100, 0, 40],
          [100, 0, 30]
        ], 2)
        that.borderXdraw(group, [
          [90, 0, 40],
          [90, 0, 50],
          [100, 0, 50],
          [100, 0, 40]
        ], 2)
        that.borderXdraw(group, [
          [90, 0, 50],
          [90, 0, 60],
          [100, 0, 60],
          [100, 0, 50]
        ], 2)
        that.floorGeometry(group, 'REP_BUF', REP_BUF, 2)
        that.borderXdraw(group, [
          [100, 0, 0],
          [100, 0, 10],
          [110, 0, 10],
          [110, 0, 0]
        ], 2)
        that.borderXdraw(group, [
          [100, 0, 40],
          [100, 0, 50],
          [110, 0, 50],
          [110, 0, 40]
        ], 2)
        that.floorGeometry(group, 'REP', REP, 2)
        that.borderXdraw(group, [
          [110, 0, 0],
          [110, 0, 10],
          [120, 0, 10],
          [120, 0, 0]
        ], 2)
        that.borderXdraw(group, [
          [110, 0, 40],
          [110, 0, 50],
          [120, 0, 50],
          [120, 0, 40]
        ], 2)
        that.floorGeometry(group, 'IN_BRIDGE_LF', IN_BRIDGE_LF, 32)
        that.floorGeometry(group, 'GATE_WAY', GATE_WAY, 2)
        that.floorGeometry(group, 'TURN', TURN, 2)
        that.floorGeometry(group, 'AG_IN_LF', AG_IN_LF, 32)
        that.floorGeometry(group, 'AG_RM_1_1', AG_RM_1_1, 2)
        that.floorGeometry(group, 'AG_RM_1_2', AG_RM_1_2, 2)
        that.floorGeometry(group, 'AG_RM_1_3', AG_RM_1_3, 2)
        that.floorGeometry(group, 'AG_RM_1_4', AG_RM_1_4, 2)
        that.floorGeometry(group, 'AG_RM_2_1', AG_RM_2_1, 2)
        that.floorGeometry(group, 'AG_RM_2_2', AG_RM_2_2, 2)
        that.floorGeometry(group, 'AG_RM_2_3', AG_RM_2_3, 2)
        that.floorGeometry(group, 'AG_RM_2_4', AG_RM_2_4, 2)
        that.floorGeometry(group, 'AG_OUT_LF', AG_OUT_LF, 32)
        that.floorGeometry(group, 'INSP', INSP, 2)
        that.floorGeometry(group, 'CL_1', CL_1, 2)
        that.floorGeometry(group, 'CL_2', CL_2, 2)
        that.floorGeometry(group, 'CL_OUT', CL_OUT, 2)
        that.floorGeometry(group, 'CL_OUT_LF', CL_OUT_LF, 32)
        that.floorGeometry(group, 'CL_OUT_RT', CL_OUT_RT, 2)
        that.floorGeometry(group, 'AG_CL_RT', AG_CL_RT, 2)
        that.floorGeometry(group, 'FT_IN_LF', FT_IN_LF, 32)
        that.floorGeometry(group, 'FI_IN_TR', FI_IN_TR, 2)
        that.floorGeometry(group, 'FI_1', FI_1, 2)
        that.borderXdraw(group, [
          [950, 0, 20],
          [950, 0, 30],
          [960, 0, 30],
          [960, 0, 20]
        ], 2)
        that.borderXdraw(group, [
          [950, 0, 30],
          [950, 0, 40],
          [960, 0, 40],
          [960, 0, 30]
        ], 2)
        that.borderXdraw(group, [
          [950, 0, 40],
          [950, 0, 50],
          [960, 0, 50],
          [960, 0, 40]
        ], 2)
        that.floorGeometry(group, 'FI_2', FI_2, 2)
        that.borderXdraw(group, [
          [960, 0, 20],
          [960, 0, 30],
          [970, 0, 30],
          [970, 0, 20]
        ], 2)
        that.borderXdraw(group, [
          [960, 0, 30],
          [960, 0, 40],
          [970, 0, 40],
          [970, 0, 30]
        ], 2)
        that.borderXdraw(group, [
          [960, 0, 40],
          [960, 0, 50],
          [970, 0, 50],
          [970, 0, 40]
        ], 2)

        that.floorGeometry(group, 'FI_TR_1', FI_TR_1, 2)
        that.floorGeometry(group, 'FI_TR_2', FI_TR_2, 2)
        that.floorGeometry(group, 'FI_3', FI_3, 2)
        that.borderXdraw(group, [
          [990, 0, 20],
          [990, 0, 30],
          [1000, 0, 30],
          [1000, 0, 20]
        ], 2)
        that.borderXdraw(group, [
          [990, 0, 30],
          [990, 0, 40],
          [1000, 0, 40],
          [1000, 0, 30]
        ], 2)
        that.borderXdraw(group, [
          [990, 0, 40],
          [990, 0, 50],
          [1000, 0, 50],
          [1000, 0, 40]
        ], 2)
        that.floorGeometry(group, 'FI_4', FI_4, 2)
        that.borderXdraw(group, [
          [1000, 0, 20],
          [1000, 0, 30],
          [1010, 0, 30],
          [1010, 0, 20]
        ], 2)
        that.borderXdraw(group, [
          [1000, 0, 30],
          [1000, 0, 40],
          [1010, 0, 40],
          [1010, 0, 30]
        ], 2)
        that.borderXdraw(group, [
          [1000, 0, 40],
          [1000, 0, 50],
          [1010, 0, 50],
          [1010, 0, 40]
        ], 2)
        that.floorGeometry(group, 'FT_IN_TR', FT_IN_TR, 2)
        that.floorGeometry(group, 'FT_1', FT_1, 2)
        that.borderXdraw(group, [
          [1020, 0, 10],
          [1020, 0, 20],
          [1030, 0, 20],
          [1030, 0, 10]
        ], 2)
        that.borderXdraw(group, [
          [1020, 0, 20],
          [1020, 0, 30],
          [1030, 0, 30],
          [1030, 0, 20]
        ], 2)
        that.borderXdraw(group, [
          [1020, 0, 30],
          [1020, 0, 40],
          [1030, 0, 40],
          [1030, 0, 30]
        ], 2)
        that.floorGeometry(group, 'FT_2', FT_2, 2)
        that.borderXdraw(group, [
          [1030, 0, 10],
          [1030, 0, 20],
          [1040, 0, 20],
          [1040, 0, 10]
        ], 2)
        that.borderXdraw(group, [
          [1030, 0, 20],
          [1030, 0, 30],
          [1040, 0, 30],
          [1040, 0, 20]
        ], 2)
        that.borderXdraw(group, [
          [1030, 0, 30],
          [1030, 0, 40],
          [1040, 0, 40],
          [1040, 0, 30]
        ], 2)
        that.floorGeometry(group, 'FT_3', FT_3, 2)
        that.borderXdraw(group, [
          [1040, 0, 10],
          [1040, 0, 20],
          [1050, 0, 20],
          [1050, 0, 10]
        ], 2)
        that.borderXdraw(group, [
          [1040, 0, 20],
          [1040, 0, 30],
          [1050, 0, 30],
          [1050, 0, 20]
        ], 2)
        that.borderXdraw(group, [
          [1040, 0, 30],
          [1040, 0, 40],
          [1050, 0, 40],
          [1050, 0, 30]
        ], 2)
        that.floorGeometry(group, 'FT_4', FT_4, 2)
        that.borderXdraw(group, [
          [1050, 0, 10],
          [1050, 0, 20],
          [1060, 0, 20],
          [1060, 0, 10]
        ], 2)
        that.borderXdraw(group, [
          [1050, 0, 20],
          [1050, 0, 30],
          [1060, 0, 30],
          [1060, 0, 20]
        ], 2)
        that.borderXdraw(group, [
          [1050, 0, 30],
          [1050, 0, 40],
          [1060, 0, 40],
          [1060, 0, 30]
        ], 2)
        that.floorGeometry(group, 'FT_5', FT_5, 2)
        that.borderXdraw(group, [
          [1060, 0, 0],
          [1060, 0, 10],
          [1070, 0, 10],
          [1070, 0, 0]
        ], 2)
        that.borderXdraw(group, [
          [1060, 0, 10],
          [1060, 0, 20],
          [1070, 0, 20],
          [1070, 0, 10]
        ], 2)
        that.borderXdraw(group, [
          [1060, 0, 20],
          [1060, 0, 30],
          [1070, 0, 30],
          [1070, 0, 20]
        ], 2)
        that.floorGeometry(group, 'FT_6', FT_6, 2)
        that.borderXdraw(group, [
          [1070, 0, 0],
          [1070, 0, 10],
          [1080, 0, 10],
          [1080, 0, 0]
        ], 2)
        that.borderXdraw(group, [
          [1070, 0, 10],
          [1070, 0, 20],
          [1080, 0, 20],
          [1080, 0, 10]
        ], 2)
        that.borderXdraw(group, [
          [1070, 0, 20],
          [1070, 0, 30],
          [1080, 0, 30],
          [1080, 0, 20]
        ], 2)
        that.floorGeometry(group, 'FT_7', FT_7, 2)
        that.borderXdraw(group, [
          [1080, 0, 0],
          [1080, 0, 10],
          [1090, 0, 10],
          [1090, 0, 0]
        ], 2)
        that.borderXdraw(group, [
          [1080, 0, 10],
          [1080, 0, 20],
          [1090, 0, 20],
          [1090, 0, 10]
        ], 2)
        that.borderXdraw(group, [
          [1080, 0, 20],
          [1080, 0, 30],
          [1090, 0, 30],
          [1090, 0, 20]
        ], 2)
        that.floorGeometry(group, 'FT_8', FT_8, 2)
        that.borderXdraw(group, [
          [1090, 0, 0],
          [1090, 0, 10],
          [1100, 0, 10],
          [1100, 0, 0]
        ], 2)
        that.borderXdraw(group, [
          [1090, 0, 10],
          [1090, 0, 20],
          [1100, 0, 20],
          [1100, 0, 10]
        ], 2)
        that.borderXdraw(group, [
          [1090, 0, 20],
          [1090, 0, 30],
          [1100, 0, 30],
          [1100, 0, 20]
        ], 2)
        that.floorGeometry(group, 'LOAD_OUT', LOAD_OUT, 2)
        that.floorGeometry(group, 'LOAD_OUT_LF', LOAD_OUT_LF, 32)
        that.floorGeometry(group, 'FT_RT', FT_RT, 2)
      }

      drawFactory(this, group1)

      var cube = new THREE.Mesh(new THREE.BoxGeometry(4, 4, 4), new THREE.MeshLambertMaterial({ color: 0xffdd00 }))
      cube.position.x = -20
      cube.position.y = 2
      this.floorGroup[0].add(cube)

      this.wall(this.floorGroup[0], [10, 30, 10], [35, 15, -30], 1,
        [{ size: [8, 40, 10], position: [35, 15, -30] }, { size: [10, 40, 8], position: [35, 15, -30] }])

      // pc object
      this.addPC(0, 'fusingPC', { x: 65, y: 1, z: 55 })
      this.addPC(0, 'assyTestAoi1PC', { x: 85, y: 1, z: 25 })
      this.addPC(0, 'assyTestAoi1PC', { x: 95, y: 1, z: 25 })
      this.addPC(0, 'repairPC', { x: 115, y: 1, z: -5 })
      this.addPC(0, 'inspPC', { x: 625, y: 1, z: 45 })
      this.addPC(0, 'ftAoi1PC', { x: 955, y: 1, z: 15 })
      this.addPC(0, 'ftAoi2PC', { x: 965, y: 1, z: 15 })
      this.addPC(0, 'ftAoi3PC', { x: 995, y: 1, z: 15 })
      this.addPC(0, 'ftAoi4PC', { x: 1005, y: 1, z: 15 })
      this.addPC(0, 'ft1PC', { x: 1025, y: 1, z: 45 })
      this.addPC(0, 'ft2PC', { x: 1035, y: 1, z: 45 })
      this.addPC(0, 'ft3PC', { x: 1045, y: 1, z: 45 })
      this.addPC(0, 'ft4PC', { x: 1055, y: 1, z: 45 })
      this.addPC(0, 'ft5PC', { x: 1065, y: 1, z: -5 })
      this.addPC(0, 'ft6PC', { x: 1075, y: 1, z: -5 })
      this.addPC(0, 'ft7PC', { x: 1085, y: 1, z: -5 })
      this.addPC(0, 'ft8PC', { x: 1095, y: 1, z: -5 })

      // plc object
      this.addPLC(0, 'assyPLC', { x: -35, y: 1, z: 0 })
      this.addPLC(0, 'assyTestPLC', { x: 115, y: 1, z: 55 })
      this.addPLC(0, 'assyAoiPLC', { x: 90, y: 1, z: 15 })
      this.addPLC(0, 'agPLC', { x: 375, y: 1, z: 55 })
      this.addPLC(0, 'agTPLC', { x: 395, y: 1, z: 55 })
      this.addPLC(0, 'ftAoi1PLC', { x: 960, y: 1, z: 5 })
      this.addPLC(0, 'ftAoi2PLC', { x: 1000, y: 1, z: 5 })
      this.addPLC(0, 'ftPLC', { x: 1000, y: 1, z: 55 })
      var that = this
      setTimeout(function () {
        that.pcObject['ft2PC'].material = new THREE.MeshLambertMaterial({ color: 'green', side: THREE.DoubleSide })
        that.machineObject['FT_6'].material = new THREE.MeshLambertMaterial({ color: 'red', side: THREE.DoubleSide })
      }, 5000)
      // Lights
      this.scene.add(new THREE.AmbientLight(0xffffff))
      var directionalLight = new THREE.DirectionalLight(0xffffff, 0.125)
      directionalLight.position.x = Math.random() * 10 - 5
      directionalLight.position.y = Math.random() * 10 - 5
      directionalLight.position.z = Math.random() * 10 - 5
      directionalLight.position.normalize()
      this.scene.add(directionalLight)
      this.pointLight = new THREE.PointLight(0xffffff, 1)
      this.pointLight.position.y = 50
      this.scene.add(this.pointLight)
      this.renderer.render(this.scene, this.camera)

      window.addEventListener('resize', this.onWindowResize, false)
      // window.addEventListener('click', this.onDocumentMouseClick, false);

      // var group2 = new THREE.Group();
      // group2.panel = [];
      // // group2.position.z = -100;
      // // group2.position.x = -600;
      // drawFactory(this, group2);
      // this.floorGroup.push(group2);
      // var m = new THREE.Matrix4();
      // var vec = new THREE.Vector3(0, 0, 1);
      // m.set(1 - 2 * vec.x * vec.x, -2 * vec.x * vec.y, -2 * vec.x * vec.z, 0,
      //   -2 * vec.x * vec.y, 1 - 2 * vec.y * vec.y, -2 * vec.y * vec.z, 0,
      //   -2 * vec.x * vec.z, -2 * vec.y * vec.z, 1 - 2 * vec.z * vec.z, 0,
      //   0, 0, 0, 1);
      // group2.applyMatrix(m);
      // group2.translateZ(100);
      // group2.translateX(600);

      // this.add("08187", 0, {x: 85, y: 3, z: 35}, "AT01");
      // this.add("09190", 1, {x: 85, y: 3, z: 35}, "AT01");
      for (let a = 0; a < this.data.length; a++) {
        for (let b = 0; b < this.data[a].length; b++) {
          for (let c = 0; c < this.data[a][b].length; c++) {
            if (this.data[a][b][c].id !== undefined && this.data[a][b][c].id !== '') {
              var POSITION = { x: 0, y: 0, z: 0 }
              POSITION.y = 3 + a * 10
              POSITION.z = (b + 1) * 10 - 5
              POSITION.x = (c + 1) * 10 - 5
              this.addPallet(a, b, c, this.data[a][b][c], 0, POSITION)
            }
          }
        }
      }

      for (let i = 0; i < this.floorGroup.length; i++) {
        this.scene.add(this.floorGroup[i])
      }
    },
    addPC: function (LINE, NAME, POSITION) {
      var materials = new THREE.MeshBasicMaterial({ color: 'lightblue' })

      var panel = new THREE.Mesh(new THREE.CubeGeometry(5, 2, 5), materials)
      panel.position.x = POSITION.x
      panel.position.y = POSITION.y
      panel.position.z = POSITION.z
      this.pcObject[NAME] = panel
      this.floorGroup[LINE].add(panel)
    },
    addPLC: function (LINE, NAME, POSITION) {
      var materials = new THREE.MeshBasicMaterial({ color: '#61A0A8' })
      var panel = new THREE.Mesh(new THREE.BoxGeometry(10, 2, 4), materials)
      panel.position.x = POSITION.x
      panel.position.y = POSITION.y
      panel.position.z = POSITION.z
      this.plcObject[NAME] = panel
      this.floorGroup[LINE].add(panel)
    },
    addPallet: function (a, b, c, DATA, LINE, POSITION) {
      var materials = [
        new THREE.MeshBasicMaterial({ color: 'blue' }), // right
        new THREE.MeshBasicMaterial({ color: 'yellow' }), // left
        new THREE.MeshBasicMaterial({ map: new THREE.CanvasTexture(this.getTextCanvas(DATA.id)) }), // top
        new THREE.MeshBasicMaterial({ color: 'black' }), // bottom
        new THREE.MeshBasicMaterial({ color: 'green' }), // back
        new THREE.MeshBasicMaterial({ color: 'red' }) // front
      ]
      var panel = new THREE.Mesh(new THREE.CubeGeometry(8, 2, 8), materials)
      panel.position.x = POSITION.x
      panel.position.y = POSITION.y
      panel.position.z = POSITION.z
      panel.data = { id: DATA.id, recipe: Math.round(Math.random() * 300) }
      if (DATA.id === '') {
        panel.visible = false
      }

      // var outT = new TWEEN.Tween(panel.position).to( {x: POSITION.x, y: POSITION.y, z: POSITION.z+10}, 1000).onComplete(function () {
      //   panel.visible = false;
      // });
      // var inT = new TWEEN.Tween(panel.position).to( {x: POSITION.x, y: POSITION.y, z: POSITION.z}, 1000).onStart(function () {
      //   panel.visible = true;
      // });
      // panel.inT = inT;
      // panel.outT = outT;
      //
      // //this.panel.push(panel);
      // // this.floorGroup[LINE].panel.push(panel);
      this.pallet[a][b][c].p = panel
      this.floorGroup[LINE].add(panel)
    },
    dec: function (LINE, panel) {
      // 在场景中删除pallet
      this.floorGroup[LINE].remove(panel)
    },
    add: function (ID, LINE, POSITION, NAME) {
      var materials = [
        new THREE.MeshBasicMaterial({ color: 'blue' }), // right
        new THREE.MeshBasicMaterial({ color: 'yellow' }), // left
        new THREE.MeshBasicMaterial({ map: new THREE.CanvasTexture(this.getTextCanvas(ID)) }), // top
        new THREE.MeshBasicMaterial({ color: 'black' }), // bottom
        new THREE.MeshBasicMaterial({ color: 'green' }), // back
        new THREE.MeshBasicMaterial({ color: 'red' }) // front
      ]
      var panel = new THREE.Mesh(new THREE.CubeGeometry(8, 2, 8), materials)
      panel.position.x = POSITION.x
      panel.position.y = POSITION.y
      panel.position.z = POSITION.z
      panel.data = { id: ID, name: NAME }
      panel.fan = false
      var outT = new TWEEN.Tween(panel.position).to({ x: POSITION.x, y: POSITION.y, z: POSITION.z + 10 }, 1000).onComplete(function () {
        panel.visible = false
      })
      var inT = new TWEEN.Tween(panel.position).to({ x: POSITION.x, y: POSITION.y, z: POSITION.z }, 1000).onStart(function () {
        panel.visible = true
      })
      panel.inT = inT
      panel.outT = outT
      // this.panel.push(panel);
      this.floorGroup[LINE].panel.push(panel)
      this.floorGroup[LINE].add(panel)
    },
    animate: function () {
      requestAnimationFrame(this.animate)
      this.controls.update()
      TWEEN.update()
      this.renderer.render(this.scene, this.camera)
    },
    floorGeometry: function (group, name, points, height) {
      var topPoints = []
      for (let i = 0; i < points.length; i++) {
        var vertice = points[i]
        topPoints.push([vertice[0], vertice[1] + height, vertice[2]])
      }
      var totalPoints = points.concat(topPoints)
      var vertices = [] // 所有的顶点
      for (let i = 0; i < totalPoints.length; i++) {
        vertices.push(new THREE.Vector3(totalPoints[i][0], totalPoints[i][1], totalPoints[i][2]))
      }
      var length = points.length
      var faces = []
      for (let j = 0; j < length; j++) { // 侧面生成三角形
        if (j !== length - 1) {
          faces.push(new THREE.Face3(j, j + 1, length + j + 1))
          faces.push(new THREE.Face3(length + j + 1, length + j, j))
        } else {
          faces.push(new THREE.Face3(j, 0, length))
          faces.push(new THREE.Face3(length, length + j, j))
        }
      }
      var data = []
      for (let i = 0; i < length; i++) {
        data.push(points[i][0], points[i][2])
      }
      var triangles = earcut(data)
      if (triangles && triangles.length !== 0) {
        for (let i = 0; i < triangles.length; i++) {
          var tlength = triangles.length
          if (i % 3 === 0 && i < tlength - 2) {
            faces.push(new THREE.Face3(triangles[i], triangles[i + 1], triangles[i + 2])) // 底部的三角面
            faces.push(new THREE.Face3(triangles[i] + length, triangles[i + 1] + length, triangles[i + 2] + length)) // 顶部的三角面
          }
        }
      }
      var geometry = new THREE.Geometry()
      geometry.vertices = vertices
      geometry.faces = faces
      geometry.computeFaceNormals() // 自动计算法向量

      var material = new THREE.MeshLambertMaterial({ color: '#444444', side: THREE.DoubleSide })
      var mesh = new THREE.Mesh(geometry, material)
      this.machineObject[name] = mesh
      group.add(mesh)
      // return mesh;
      this.borderGeometry(group, points, height)
    },
    borderGeometry: function (group, points, height) {
      var geometry = new THREE.Geometry()
      for (var i = 0; i < points.length; i++) {
        var point = points[i]
        geometry.vertices.push(new THREE.Vector3(point[0], point[1] + height, point[2]))
        if (i === points.length - 1) {
          geometry.vertices.push(new THREE.Vector3(points[0][0], points[0][1] + height, points[0][2]))
        }
      }

      var mesh2 = new THREE.Line(geometry, new THREE.MeshLambertMaterial({ color: 0xffffff }))
      group.add(mesh2)
      // return mesh2;
    },
    borderXdraw: function (group, points, height) {
      var geometry = new THREE.Geometry()
      for (var i = 0; i < points.length; i++) {
        var point = points[i]
        geometry.vertices.push(new THREE.Vector3(point[0], point[1] + height, point[2]))
        if (i === points.length - 1) {
          geometry.vertices.push(new THREE.Vector3(points[0][0], points[0][1] + height, points[0][2]))
        }
      }
      geometry.vertices.push(new THREE.Vector3(points[2][0], points[2][1] + height, points[2][2]))
      geometry.vertices.push(new THREE.Vector3(points[3][0], points[3][1] + height, points[3][2]))
      geometry.vertices.push(new THREE.Vector3(points[1][0], points[1][1] + height, points[1][2]))

      var mesh2 = new THREE.Line(geometry, new THREE.MeshLambertMaterial({ color: 0xffffff }))
      group.add(mesh2)
    },
    wall: function (group, size, position, rotation, holes) {
      var geometry = new THREE.BoxGeometry(size[0], size[1], size[2])
      var materials = new THREE.MeshLambertMaterial({ color: 0x888888, side: THREE.DoubleSide })
      var result = new THREE.Mesh(geometry, materials)
      result.position.x = position[0]
      result.position.y = position[1]
      result.position.z = position[2]
      if (holes) {
        // result = cube;
        for (var i = 0; i < holes.length; i++) {
          var totalBSP = new ThreeBSP(result)
          var hole = holes[i]
          var holeGeometry = new THREE.BoxGeometry(hole.size[0], hole.size[1], hole.size[2])
          var holeCube = new THREE.Mesh(holeGeometry)
          holeCube.position.x = hole.position[0]
          // holeCube.position.y = hole.position[1] + hole.size[1]/2;
          holeCube.position.y = 5
          holeCube.position.z = hole.position[2]
          var clipBSP = new ThreeBSP(holeCube)
          var resultBSP = totalBSP.subtract(clipBSP)
          result = resultBSP.toMesh()
        }
        result.material = materials
      }
      group.add(result) // 添加填充
    },
    onDocumentMouseClick: function (event) {
      // event.preventDefault();
      if (this.selectedObject) {
        // this.selectedObject.material.color.set( '#'+this.selectedColor );
        this.selectedObject.material = new THREE.MeshLambertMaterial({
          color: '#' + this.selectedColor,
          side: THREE.DoubleSide
        })
        this.selectedObject = null
      }
      var vector = new THREE.Vector3()// 三维坐标对象
      vector.set(
        (event.layerX / this.width) * 2 - 1,
        -(event.layerY / this.height) * 2 + 1,
        0.5
      )
      var raycaster = new THREE.Raycaster()
      raycaster.setFromCamera(vector, this.camera)
      // var intersects = []; //楼层中的元素
      for (let i = 0; i < this.floorGroup.length; i++) {
        var intersects = raycaster.intersectObjects(this.floorGroup[i].children)
        if (intersects.length > 0) {
          this.selectedObject = intersects[0].object
          if (this.selectedObject.data !== undefined) {
            // alert('Pallet ID: ' + this.selectedObject.data.id)
            this.dialogTable.palletId = this.selectedObject.data.id
            this.dialogTable.recipe = this.selectedObject.data.recipe
            this.dialogTable.state = 'green'
            this.dialogTable.visible = true
            this.selectedObject = null
          } else {
            this.selectedColor = this.selectedObject.material.color.getHexString()
            // this.selectedObject.material.color.set( '#f00' );
            this.selectedObject.material = new THREE.MeshLambertMaterial({ color: '#f86332', side: THREE.DoubleSide })
          } // 选中的样式
        }
      }

      this.renderer.render(this.scene, this.camera)
    },
    onWindowResize () {
      this.width = window.innerWidth - 40
      // this.height = window.innerHeight / 3,
      this.camera.aspect = this.width / this.height
      this.camera.updateProjectionMatrix()
      this.renderer.setSize(this.width, this.height)
      this.controls.handleResize()
    },
    drawPanel (id) {
      var c = document.createElement('canvas')
      c.width = 10
      c.height = 10
      c.style = 'border:1px solid #d3d3d3;'
      var ctx = c.getContext('2d')
      ctx.font = '5px Arial'
      ctx.fillStyle = '#FF0000'
      ctx.fillText('09190', 0, 10)

      // // Create gradient
      // var grd=ctx.createLinearGradient(0,0,10,0);
      // grd.addColorStop(0,"red");
      // grd.addColorStop(1,"white");
      // // Fill with gradient
      // ctx.fillStyle=grd;
      // ctx.fillRect(0,0,10,10);

      return c
    },
    getTextCanvas (text) {
      var width = 512
      var height = 256
      var canvas = document.createElement('canvas')
      canvas.width = width
      canvas.height = height
      var ctx = canvas.getContext('2d')
      ctx.fillStyle = '#FFFFFF'
      ctx.fillRect(0, 0, width, height)
      ctx.font = 150 + 'px " bold'
      ctx.fillStyle = '#000000'
      ctx.textAlign = 'center'
      ctx.textBaseline = 'middle'
      ctx.fillText(text, width / 2, height / 2)
      return canvas
    },
    initChartCapacity () {
      // 初始化echarts实例
      var myChart = this.$echarts.init(document.getElementById('chartCapacity'))
      // 使用制定的配置项和数据显示图表
      myChart.setOption(this.capacityOption)
    },
    initChartTactTime () {
      var myChart = this.$echarts.init(document.getElementById('chartTactTime'))
      // 使用制定的配置项和数据显示图表
      myChart.setOption(this.tactTimeOption)
    },
    initChartCounter () {
      // 初始化echarts实例
      var myChart = this.$echarts.init(document.getElementById('chartCounter'))
      // 使用制定的配置项和数据显示图表
      myChart.setOption(this.counterOption)
    },
    initChartTemp () {
      var myChart = this.$echarts.init(document.getElementById('chartTemp'))
      // 使用制定的配置项和数据显示图表
      myChart.setOption(this.temperatureOption)
    },
    initChartMachineState () {
      var myChart = this.$echarts.init(document.getElementById('chartMachineState'))
      // 使用制定的配置项和数据显示图表
      myChart.setOption(this.machineStateOption)
    },
    delArrElem (arr, id) {
      var i = arr.length
      while (i--) {
        if (arr[i].id === id) {
          arr.splice(i, 1)
        }
      }
      // return arr;
    }
  },
  mounted () {
    // this.SETALARMCOUNT(this.alarmList.length)
    this.oldData = JSON.parse(JSON.stringify(this.data))
    this.init()
    this.animate()
    this.initChartCapacity()
    this.initChartTemp()
    this.initChartCounter()
    this.initChartTactTime()
    this.initChartMachineState()

    var that = this
    this.websocket.setConnectCallback(function (client) {
      client.subscribe('/topic/temperature', function (data) {
        // console.log(data.body)
        let temp = JSON.parse(data.body)
        that.temperatureOption.series[0].data[1] = temp.ch1
        that.temperatureOption.series[0].data[2] = temp.ch2
        that.temperatureOption.series[0].data[3] = temp.ch3
        that.temperatureOption.series[0].data[4] = temp.ch4
        that.temperatureOption.series[0].data[5] = temp.ch5
        that.temperatureOption.series[0].data[6] = temp.ch6
        that.temperatureOption.series[0].data[7] = temp.ch7
        that.temperatureOption.series[0].data[8] = temp.ch8
        that.temperatureOption.series[0].data[9] = temp.ch9
        that.temperatureOption.series[0].data[10] = temp.ch10
        that.temperatureOption.series[0].data[11] = temp.ch11
        that.temperatureOption.series[0].data[12] = temp.ch12
        that.temperatureOption.series[1].data[1] = temp.clch1
        that.temperatureOption.series[1].data[2] = temp.clch2
        let totalAg = 0
        let len = that.temperatureOption.series[0].data.length
        for (let i = 0; i < len; i++) {
          if (i !== 0) {
            totalAg += that.temperatureOption.series[0].data[i]
          }
        }
        that.temperatureOption.series[0].data[0] = Math.round(totalAg / (len - 1))
        that.temperatureOption.series[1].data[0] = Math.round((that.temperatureOption.series[1].data[1] + that.temperatureOption.series[1].data[2]) / 2)
        that.initChartTemp()
      })

      client.subscribe('/topic/yield', function (data) {
        // console.log(data.body)
        let temp = JSON.parse(data.body)
        that.capacityOption.series[0].data[0] = temp.classA
        that.capacityOption.series[0].data[1] = temp.classB
        that.capacityOption.series[0].data[2] = that.capacityOption.series[0].data[0] + that.capacityOption.series[0].data[1]
        that.initChartCapacity()
      })

      client.subscribe('/topic/tacttime', function (data) {
        // console.log(data.body)
        let temp = JSON.parse(data.body)
        that.tactTimeOption.series[0].data[0] = Math.floor(temp.assy / 10)
        that.tactTimeOption.series[0].data[1] = Math.floor(temp.fusing / 10)
        that.tactTimeOption.series[0].data[2] = Math.floor(temp.aoi / 10)
        that.tactTimeOption.series[0].data[3] = Math.floor(temp.agingIn / 10)
        that.tactTimeOption.series[0].data[4] = Math.floor(temp.agingOut / 10)
        that.tactTimeOption.series[0].data[5] = Math.floor(temp.agingInsp / 10)
        that.tactTimeOption.series[0].data[6] = Math.floor(temp.aoi01 / 10)
        that.tactTimeOption.series[0].data[7] = Math.floor(temp.aoi02 / 10)
        that.tactTimeOption.series[0].data[8] = Math.floor(temp.ft / 10)
        that.initChartTactTime()
      })

      client.subscribe('/topic/alarm', function (data) {
        // console.log(data.body)
        let temp = JSON.parse(data.body)
        that.delArrElem(that.alarmList, temp.id)
        that.alarmList.push(temp)
      })
      client.subscribe('/topic/pallet', function (data) {
        // console.log(data.body)
        let temp = JSON.parse(data.body)
        let a = temp.a
        let b = temp.b
        let c = temp.c
        that.data[a][b][c].id = temp.id
      })
      client.subscribe('/topic/simulate', function (data) {
        // console.log(data.body)
        let temp = JSON.parse(data.body)
        let a = temp.a
        let b = temp.b
        let c = temp.c
        that.data[a][b][c].x = temp.x
        that.data[a][b][c].y = temp.y
        that.data[a][b][c].z = temp.z
        that.data[a][b][c].m = temp.m
        that.data[a][b][c].o = temp.o
      })
      client.subscribe('/topic/counter', function (data) {
        let temp = JSON.parse(data.body)
        that.counterOption.series[0].data[0] = temp.totalPanels
        that.counterOption.series[1].data[0] = temp.agingPanels
        that.counterOption.series[2].data[0] = temp.totalPallets
        that.counterOption.series[3].data[0] = temp.agingPallets
        that.counterOption.series[4].data[0] = temp.processPallets
        that.counterOption.series[5].data[0] = temp.completedPallets
        that.counterOption.series[6].data[0] = temp.overtimePallets
        that.counterOption.series[7].data[0] = temp.emptyPallets
        that.initChartCounter()
      })
      client.subscribe('/topic/statem', function (data) {
        let temp = JSON.parse(data.body)
        for (let y = 0; y < that.machineStateOption.series.length; y++) {
          if (temp.assy === that.machineStateOption.series[y].name) {
            that.machineStateOption.series[y].data[0] = 1
          } else {
            that.machineStateOption.series[y].data[0] = 0
          }
          if (temp.fusing === that.machineStateOption.series[y].name) {
            that.machineStateOption.series[y].data[1] = 1
          } else {
            that.machineStateOption.series[y].data[1] = 0
          }
          if (temp.aoi === that.machineStateOption.series[y].name) {
            that.machineStateOption.series[y].data[2] = 1
          } else {
            that.machineStateOption.series[y].data[2] = 0
          }
          if (temp.aging === that.machineStateOption.series[y].name) {
            that.machineStateOption.series[y].data[3] = 1
          } else {
            that.machineStateOption.series[y].data[3] = 0
          }
          if (temp.agingInsp === that.machineStateOption.series[y].name) {
            that.machineStateOption.series[y].data[4] = 1
          } else {
            that.machineStateOption.series[y].data[4] = 0
          }
          if (temp.aoi01 === that.machineStateOption.series[y].name) {
            that.machineStateOption.series[y].data[5] = 1
          } else {
            that.machineStateOption.series[y].data[5] = 0
          }
          if (temp.aoi02 === that.machineStateOption.series[y].name) {
            that.machineStateOption.series[y].data[6] = 1
          } else {
            that.machineStateOption.series[y].data[6] = 0
          }
        }
        that.initChartMachineState()
      })
      client.subscribe('/topic/connections', function (data) {
        let temp = JSON.parse(data.body)
        for (let i = 0; i < that.plcConnections.length; i++) {
          if (that.plcConnections[i].id === temp.id) {
            that.plcConnections[i].time = temp.time.toFixed(3)
            if (temp.con === 1) {
              that.plcConnections[i].con = '#B5C334'
            } else {
              that.plcConnections[i].con = '#C1232B'
            }
          }
        }
        for (let i = 0; i < that.pcConnections.length; i++) {
          if (that.pcConnections[i].id === temp.id) {
            that.pcConnections[i].time = temp.time.toFixed(3)
            if (temp.con === 1) {
              that.pcConnections[i].con = '#B5C334'
            } else {
              that.pcConnections[i].con = '#C1232B'
            }
          }
        }
        for (let x in that.pcObject) {
          if (x === temp.id) {
            that.pcObject[x].material = new THREE.MeshLambertMaterial({ color: 'green', side: THREE.DoubleSide })
          }
        }
        for (let x in that.plcObject) {
          if (x === temp.id) {
            that.plcObject[x].material = new THREE.MeshLambertMaterial({ color: 'green', side: THREE.DoubleSide })
          }
        }
      })
    })
    this.websocket.setCloseCallback(function (client) {
      client.unsubscribe('/topic/temperature')
      client.unsubscribe('/topic/yield')
      client.unsubscribe('/topic/tacttime')
      client.unsubscribe('/topic/alarm')
      client.unsubscribe('/topic/pallet')
      client.unsubscribe('/topic/simulate')
      client.unsubscribe('/topic/counter')
      client.unsubscribe('/topic/statem')
      client.unsubscribe('/topic/connections')
    })
    this.websocket.initWebSocket()
  },
  destroyed () {
    this.websocket.close()
  }
}
</script>

<style>
  #container{
    /*box-shadow: 0px 0px 5px #888888;*/
  }
  .agingBack {
    padding: 3px 0;
    color: white;
  }

.connectionDiv {
    border-style: solid;
    border-width: 0px 39px 39px 39px;
    border-color: transparent transparent #ccc transparent;
    width: 0px;
    height: 0px;
    float: left;
    margin: 1px;
    font-size: 8px;
    padding: 20px 0;
    text-align: left;
  }
  .connectionDiv-time {
    padding: 5px 0;
    width: 50px;
    height: 20px;
    text-align: center;
    margin-left: -25px;
  }
  .connectionDiv-name {
    padding: 5px 0;
    width: 80px;
    height: 20px;
    text-align: center;
    margin-left: -40px;
    margin-top: 17px;
  }
  .pcConnectionDiv {
    border-style: solid;
    border-width: 51px 0px 0px 51px;
    border-color: transparent transparent transparent #ccc;
    width: 0px;
    height: 0px;
    float: left;
    margin: 1px;
    font-size: 8px;
    padding: 0 0;
    text-align: left;
  }
  @media only screen and (min-width: 1310px) {
    .connectionDiv {
      border-style: solid;
      border-width: 0px 39px 39px 39px;
      border-color: transparent transparent #ccc transparent;
      width: 0px;
      height: 0px;
      float: left;
      margin: 1px;
      font-size: 8px;
      padding: 20px 0;
      text-align: left;
    }
    .connectionDiv-time {
      padding: 5px 0;
      width: 50px;
      height: 20px;
      text-align: center;
      margin-left: -25px;
    }
    .connectionDiv-name {
      padding: 5px 0;
      width: 80px;
      height: 20px;
      text-align: center;
      margin-left: -40px;
      margin-top: 17px;
    }
    .pcConnectionDiv {

      border-style: solid;
      border-width: 51px 0px 0px 51px;
      border-color: transparent transparent transparent #ccc;
      width: 0px;
      height: 0px;
      float: left;
      margin: 1px;
      font-size: 8px;
      padding: 0 0;
      text-align: left;
    }
  }

  @media only screen and (min-width: 1900px) {
    .connectionDiv {
      border-style: solid;
      border-width: 0px 40px 40px 40px;
      border-color: transparent transparent #ccc transparent;
      width: 0px;
      height: 0px;
      float: left;
      margin: 5px;
      font-size: 9px;
      padding: 20px 0;
      text-align: left;
    }
    .connectionDiv-time {
      padding: 5px 0;
      width: 80px;
      height: 20px;
      text-align: center;
      margin-left: -40px;
    }
    .connectionDiv-name {
      padding: 5px 0;
      width: 80px;
      height: 20px;
      text-align: center;
      margin-left: -40px;
      margin-top: 25px;
    }
    .pcConnectionDiv {
      border-style: solid;
      border-width: 53px 0px 0px 53px;
      border-color: transparent transparent transparent #ccc;
      width: 0px;
      height: 0px;
      float: left;
      margin: 5px;
      font-size: 9px;
      padding: 0 0;
      text-align: left;
    }
  }

  .stateBack {
    width: 10px;
    height: 10px;
    border-radius: 10px;
    margin: auto;
  }

  .alarm-count {
    position: relative;
    left: 3px;
    top: 3px;
    width: 20px;
    height: 20px;
    border-radius: 20px;
    background-color: red;
    text-align: center;
    line-height: 20px;

    animation-duration: 3s;   /* 动画持续时间 */
    animation-delay: 5s;   /* 动画延迟时间 */
    /* animation-iteration-count: 2;  动画执行次数 */
  }

 .myTable .el-table .cell {
    padding: 0px;
    line-height: 10px;
    text-align: center;
    margin: auto;
  }
  .myTable .el-table td {
    height: 29px;
  }
  .el-table .cell, .el-table th div, .el-table--border td:first-child .cell, .el-table--border th:first-child .cell {
    padding-left: 0;
  }
  .el-collapse-item__content {
    padding-bottom: 0;
  }
  .el-collapse-item__header {
    height: 20px;
  }
  .el-tabs--border-card>.el-tabs__content {
    padding: 0;
  }
  .el-tabs--left .el-tabs__header.is-left {
    margin-right: 0;
  }
  .el-tabs--left.el-tabs--border-card .el-tabs__item.is-left {
    margin: -1px 1px -1px -1px;
  }
  .el-tabs__item {
    height: 42.5px;
    line-height: 42.5px;
  }
  #dashboard .el-card__body {
    padding: 0;
  }
  #dashboard .el-card__header {
    padding: 0;
  }
</style>
