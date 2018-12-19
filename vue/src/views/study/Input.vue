<template>
  <div id ="input">
      <h2>基础用法</h2>
      <el-input v-model="input" placeholder="请输入内容"></el-input>
      <el-input v-model="input1" placeholder="请输入内容" :disabled="true"></el-input>
      <el-input v-model="input1" placeholder="请输入内容" clearable></el-input>
      <br/>
      <h2>带icon的输入框</h2>
      <el-row :gutter="20">
        <el-col :span="3">属性方式:</el-col>
        <el-col :span="8"><el-input placeholder="请选择日期" suffix-icon="el-icon-date" v-model="input2" size="samll"></el-input></el-col>
        <el-col :span="8"><el-input placeholder="请输入内容" prefix-icon="el-icon-search" v-model="input21"></el-input></el-col>
      </el-row>
      <br/>
      <div class="demo-input-suffix">
        <el-row :gutter="20">
          <el-col :span="3">slot方式:</el-col>
          <el-col :span="8"><el-input placeholder="请选择日期" v-model="input2"><i slot="suffix" class="el-input_icon el-icon-date"></i></el-input></el-col>
          <el-col :span="8"><el-input placeholder="请输入内容" v-model="input21"><i slot="prefix" class="el-input_icon el-icon-search"></i></el-input></el-col>
        </el-row>
      </div>

      <br/>
      <h2>文本域</h2>
      <el-input :rows="2" placeholder="请输入内容" type="textarea" v-model="textarea"></el-input>
      <br/>
      <el-input autosize placeholder="请输入内容" type="textarea" v-model="textarea"></el-input>
      <br/>
      <el-input :autosize="{ minRows: 2, maxRows: 4}" placeholder="请输入内容" type="textarea" v-model="textarea"></el-input>

      <br/>
      <h2>尺寸</h2>
      <div class="demo-input-size">
        <el-input
          placeholder="请输入内容"
          suffix-icon="el-icon-date"
          v-model="input6">
        </el-input>
        <el-input
          size="medium"
          placeholder="请输入内容"
          suffix-icon="el-icon-date"
          v-model="input7">
        </el-input>
        <el-input
          size="small"
          placeholder="请输入内容"
          suffix-icon="el-icon-date"
          v-model="input8">
        </el-input>
        <el-input
          size="mini"
          placeholder="请输入内容"
          suffix-icon="el-icon-date"
          v-model="input9">
        </el-input>
      </div>

      <br/>
      <h2>复合型输入框</h2>
      <div>
        <el-input placeholder="请输入内容" v-model="input3">
          <template slot="prepend">Http://</template>
        </el-input>
      </div>
      <div style="margin-top: 15px;">
        <el-input placeholder="请输入内容" v-model="input4">
          <template slot="append">.com</template>
        </el-input>
      </div>
      <div style="margin-top: 15px;">
        <el-input placeholder="请输入内容" v-model="input5" class="input-with-select">
          <el-select v-model="select" slot="prepend" placeholder="请选择">
            <el-option label="餐厅名" value="1"></el-option>
            <el-option label="订单号" value="2"></el-option>
            <el-option label="用户电话" value="3"></el-option>
          </el-select>
          <el-button slot="append" icon="el-icon-search"></el-button>
        </el-input>
      </div>

      <br/>
      <h2>
        带输入建议
      </h2>
      <el-row class="demo-autocomplete">
        <el-col :span="12">
          <div class="sub-title">激活即列出输入建议</div>
          <el-autocomplete
            class="inline-input"
            v-model="state1"
            :fetch-suggestions="querySearch"
            placeholder="请输入内容"
            @select="handleSelect"
          ></el-autocomplete>
        </el-col>
        <el-col :span="12">
          <div class="sub-title">输入后匹配输入建议</div>
          <el-autocomplete
            class="inline-input"
            v-model="state2"
            :fetch-suggestions="querySearch"
            placeholder="请输入内容"
            :trigger-on-focus="false"
            @select="handleSelect"
          ></el-autocomplete>
        </el-col>
      </el-row>

      <br/>
      <h2>远程搜索</h2>
      <el-autocomplete
        v-model="state4"
        :fetch-suggestions="querySearchAsync"
        placeholder="请输入内容"
        @select="handleSelect">
      </el-autocomplete>

      <br/>
      <h2>InputNumber按钮</h2>
      <el-input-number v-model="num8" controls-position="right"></el-input-number>
  </div>
</template>

<script>
export default {
  data () {
    return {
      input: '',
      input1: '',
      input2: '',
      input21: '',

      textarea: '',

      input3: '',
      input4: '',
      input5: '',
      select: '',

      input6: '',
      input7: '',
      input8: '',
      input9: '',

      restaurants: [],
      state1: '',
      state2: '',

      state4: '',
      timeout: null,

      num8: 10
    }
  },
  methods: {
    querySearchAsync (queryString, cb) {
      var restaurants = this.restaurants
      var results = queryString ? restaurants.filter(this.createFilter(queryString)) : restaurants

      clearTimeout(this.timeout)
      this.timeout = setTimeout(() => {
        cb(results)
      }, 3000 * Math.random())
    },
    querySearch (queryString, cb) {
      var restaurants = this.restaurants
      var results = queryString ? restaurants.filter(this.createFilter(queryString)) : restaurants
      // 调用 callback 返回建议列表的数据
      cb(results)
    },
    createFilter (queryString) {
      return (restaurant) => {
        return (restaurant.value.toLowerCase().indexOf(queryString.toLowerCase()) === 0)
      }
    },
    loadAll () {
      return [
        { 'value': '三全鲜食（北新泾店)', 'address': '长宁区新渔路144号' },
        { 'value': 'Hot honey 首尔炸鸡（仙霞路)', 'address': '上海市长宁区淞虹路661号' }
      ]
    },
    handleSelect (item) {
      console.log(item.value + ' ' + item.address)
    }
  },
  mounted () {
    this.restaurants = this.loadAll()
  }
}
</script>

<style>
  #input {
    width: 800px;
    border: 1px solid #dddddd;
    padding: 50px;
  }

  h2 {
    color: dodgerblue;
  }

  .demo-input-size .el-input{
    width: 150px;
  }
  .demo-input-suffix i {
    margin-top: 13px;
  }

  .el-select .el-input {
    width: 130px;
  }

  .input-with-select .el-input-group__prepend {
    background-color: green;
  }
</style>
