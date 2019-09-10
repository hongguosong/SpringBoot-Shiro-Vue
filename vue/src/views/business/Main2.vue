<template>
  <div id="main2">
    <!-- <el-button @click="add(palletId, value)" size="mini">Add</el-button>
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
    <el-button @click="remoteStart" size="mini">remoteStart</el-button> -->

    <el-card>
      <div id="container">
        <!-- <div class="alarm-count animated fadeIn infinite" v-show="alarmList.length">
          <a href="#myTable">{{alarmList.length}}</a>
        </div> -->
        <div id="agingModelHor">
          <div class="line" v-for="(item, key, index) in dev" v-bind:key="index">
            <div v-for="(ee, key, index) in item" v-bind:key="index">
              <div v-if="ee.pc" class="devPc" v-bind:style="{backgroundColor: ee.color, backgroundImage: mycomputer}"></div>
              <div v-else class="dev" v-bind:style="{backgroundColor: ee.color}" v-text="ee.flag"></div>
            </div>
          </div>
        </div>
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
export default {
  name: 'main2',
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
      },
      mycomputer: 'url(' + require('../../images/mycomputer.png') + ')',
      dev: [
        [ { flag: 'InputTest' }, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {},
          { flag: 'AgingRoom' }, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {},
          {}, {}, {},
          { flag: 'CoolingRoom' }, {}, {}, {},
          {}, {}, {}, {}, {},
          { flag: 'AOI' }, {}, {}, {}, {}, {}, {},
          { flag: 'FT' }, {}, {}, {}, {}, { color: 'white', pc: true }, { color: 'white', pc: true }, { color: 'white', pc: true }, { color: 'white', pc: true },
          {}, {}, {}, {} ],
        [ { color: 'lightblue' }, { color: 'lightblue' }, { color: 'lightblue' }, { color: 'orange' }, {}, {}, {}, {}, {}, {}, { color: 'lightblue' }, { color: 'lightblue' }, {}, {}, {}, {},
          {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {},
          {}, {}, {},
          {}, {}, {}, {},
          {}, {}, {}, {}, {},
          {}, {}, {}, {}, {}, {}, {},
          {}, {}, {}, {}, {}, { color: 'lightblue' }, { color: 'lightblue' }, { color: 'lightblue' }, { color: 'lightblue' },
          {}, {}, {}, {} ],
        [ { color: 'lightblue' }, {}, {}, {}, {}, {}, {}, {}, {}, {}, { color: 'lightblue' }, { color: 'lightblue' }, {}, {}, {}, {},
          {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {},
          {}, {}, {},
          {}, {}, {}, {},
          {}, {}, {}, {}, {},
          {}, { color: 'white', pc: true }, { color: 'white', pc: true }, {}, {}, { color: 'white', pc: true }, { color: 'white', pc: true },
          { color: 'lightblue' }, { color: 'lightblue' }, { color: 'lightblue' }, { color: 'lightblue' }, { color: 'lightblue' }, { color: 'lightblue' }, { color: 'lightblue' }, { color: 'lightblue' }, { color: 'lightblue' },
          {}, {}, {}, {} ],
        [ { color: 'lightblue' }, { color: 'lightblue' }, { color: 'lightblue' }, { color: 'lightblue' }, { color: 'lightblue' }, { color: 'lightblue' }, { color: 'lightblue' }, { color: 'lightblue' }, { color: 'red', pc: true }, { color: 'green', pc: true }, { color: 'lightblue' }, { color: 'lightblue' }, {}, {}, {}, {},
          { flag: '43' }, { flag: '42' }, { flag: '41' }, { flag: '40' }, { flag: '39' }, { flag: '>>' }, { flag: '>>' }, { flag: '5' }, { flag: '4' }, { flag: '3' }, { flag: '2' }, { flag: '1' }, {},
          {}, {}, {},
          { flag: '23' }, { flag: '>>' }, { flag: '>>' }, { flag: '1' },
          {}, {}, {}, {}, {},
          {}, { color: 'lightblue' }, { color: 'lightblue' }, {}, {}, { color: 'lightblue' }, { color: 'lightblue' },
          { color: 'lightblue' }, { color: 'lightblue' }, { color: 'lightblue' }, { color: 'lightblue' }, { color: 'lightblue' }, { color: 'lightblue' }, { color: 'lightblue' }, { color: 'lightblue' }, { color: 'lightblue' },
          { color: 'lightblue' }, { color: 'lightblue' }, { color: 'lightblue' }, { color: 'orange' } ],
        [ {}, {}, {}, {}, {}, {}, {}, { color: 'lightblue' }, { color: 'lightblue' }, { color: 'lightblue' }, { color: 'lightblue' }, { color: 'lightblue' }, {}, {}, {}, { color: 'orange' },
          { color: 'lightblue' }, { color: 'lightblue' }, { color: 'lightblue' }, { color: 'lightblue' }, { color: 'lightblue' }, { color: 'lightblue' }, { color: 'lightblue' }, { color: 'lightblue' }, { color: 'lightblue' }, { color: 'lightblue' }, { color: 'lightblue' }, { color: 'lightblue' }, { color: 'orange' },
          { color: 'lightblue' }, { color: 'lightblue' }, { color: 'lightblue' },
          { color: 'lightblue' }, { color: 'lightblue' }, { color: 'lightblue' }, { color: 'lightblue' },
          { color: 'lightblue' }, { color: 'orange' }, { color: 'lightblue' }, { color: 'lightblue' }, { color: 'orange' },
          { color: 'lightblue' }, { color: 'lightblue' }, { color: 'lightblue' }, { color: 'lightblue' }, { color: 'lightblue' }, { color: 'lightblue' }, { color: 'lightblue' },
          { color: 'lightblue' }, { color: 'lightblue' }, { color: 'lightblue' }, { color: 'lightblue' }, { color: 'lightblue' }, {}, {}, {}, {},
          {}, {}, {}, {} ],
        [ {}, {}, {}, {}, {}, {}, {}, { color: 'lightblue' }, { color: 'lightblue' }, { color: 'lightblue' }, { color: 'lightblue' }, { color: 'lightblue' }, { color: 'orange' }, { color: 'lightblue' }, { color: 'lightblue' }, { color: 'orange' },
          { color: 'lightblue' }, { color: 'lightblue' }, { color: 'lightblue' }, { color: 'lightblue' }, { color: 'lightblue' }, { color: 'lightblue' }, { color: 'lightblue' }, { color: 'lightblue' }, { color: 'lightblue' }, { color: 'lightblue' }, { color: 'lightblue' }, { color: 'lightblue' }, { color: 'orange' },
          {}, { color: 'lightblue' }, {},
          { color: 'lightblue' }, { color: 'lightblue' }, { color: 'lightblue' }, { color: 'lightblue' },
          {}, {}, {}, {}, {},
          { color: 'lightblue' }, { color: 'lightblue' }, { color: 'lightblue' }, { color: 'lightblue' }, { color: 'lightblue' }, { color: 'lightblue' }, { color: 'lightblue' },
          {}, { color: 'white', pc: true }, { color: 'white', pc: true }, { color: 'white', pc: true }, { color: 'white', pc: true }, {}, {}, {}, {},
          {}, {}, {}, {} ],
        [ {}, {}, {}, {}, {}, {}, { color: 'white', pc: true }, { color: 'lightblue' }, { color: 'lightblue' }, { color: 'lightblue' }, {}, {}, {}, {}, {}, {},
          {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {},
          {}, { color: 'white', pc: true }, {},
          {}, {}, {}, {},
          {}, {}, {}, {}, {},
          {}, {}, {}, {}, {}, {}, {}, {}, {} ],
        [ {}, {}, {}, {}, {}, {}, { flag: 'Fusing' }, {}, { flag: 'IT1' }, { flag: 'IT2' }, {}, {}, {}, {}, {}, {},
          {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {},
          {}, { flag: 'INSP' }, {},
          {}, {}, {}, {},
          {}, {}, {}, {}, {},
          {}, { flag: 'AI1' }, { flag: 'AI2' }, {}, {}, { flag: 'AI3' }, { flag: 'AI4' },
          {}, { flag: 'FT1' }, { flag: 'FT2' }, { flag: 'FT3' }, { flag: 'FT4' }, { flag: 'FT5' }, { flag: 'FT6' }, { flag: 'FT7' }, { flag: 'FT8' },
          {}, {}, {}, {} ]
      ]
    }
  },
  watch: {
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
    onWindowResize () {

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
    .dev {
      width: 20px;
      height: 20px;
      float: left;
      margin-left: 0.5px;
      margin-right: 0.5px;
      font-size: 10px;
      text-align: center;
      border-radius: 2px;
      padding: 4px 0;
    }
    .devPc {
      width: 16px;
      height: 16px;
      float: left;
      margin-left: 2.5px;
      margin-right: 2.5px;
      margin-top: 2px;
      font-size: 10px;
      text-align: center;
      border-radius: 8px;
      padding: 4px 0;
    }
    .line {
      margin: auto;
      width: 1285px;
      height: 21px;
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
    .dev {
      width: 27px;
      height: 27px;
      float: left;
      margin-left: 1px;
      margin-right: 1px;
      font-size: 12px;
      text-align: center;
      border-radius: 3px;
      padding: 4px 0;
    }
    .devPc {
      width: 21px;
      height: 21px;
      float: left;
      margin-left: 3.5px;
      margin-right: 3.5px;
      margin-top: 3px;
      font-size: 10px;
      text-align: center;
      border-radius: 11px;
      padding: 4px 0;
    }
    .line {
      margin: auto;
      width: 1839px;
      height: 28px;
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
  #mian2 .el-card__body {
    padding: 0;
  }
  #mian2 .el-card__header {
    padding: 0;
  }

  .dev-lg {
    width: 40px;
    height: 40px;
    float: left;
    margin-left: 1px;
    margin-right: 1px;
    font-size: 15px;
    text-align: center;
    border-radius: 5px;
    padding: 4px 0;
  }
  .line-lg {
    margin: auto;
    width: 2500px;
    height: 41px;
  }

  .dev-mg {
    width: 27px;
    height: 27px;
    float: left;
    margin-left: 1px;
    margin-right: 1px;
    font-size: 12px;
    text-align: center;
    border-radius: 3px;
    padding: 4px 0;
  }
  .line-mg {
    margin: auto;
    width: 1700px;
    height: 28px;
  }
</style>
