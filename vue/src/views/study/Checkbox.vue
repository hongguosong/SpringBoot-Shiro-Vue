<template>
  <div id="checkboxHere">
      <h2>单选框</h2>
      <el-checkbox v-model="checked" border size="small">备选项</el-checkbox>
      <el-checkbox v-model="checked1" disabled>备选项</el-checkbox>
      <br/>
      <h2>多选框组</h2>
      <el-checkbox-group v-model="checklist">
        <el-checkbox label="复选框A"></el-checkbox>
        <el-checkbox label="复选框B"></el-checkbox>
        <el-checkbox label="复选框C"></el-checkbox>
        <el-checkbox label="禁用" disabled></el-checkbox>
        <el-checkbox label="选中且禁用" disabled></el-checkbox>
      </el-checkbox-group>
      <br/>
      <h2>indeterminate状态</h2>

      <el-checkbox :indeterminate="isIndeterminate" v-model="checkAll" @change="handleCheckAllChange">全选</el-checkbox>
      <br/>
      <el-checkbox-group v-model="checkedCities" >
        <el-checkbox v-for="city in cities" :label="city" :key="city">{{city}}</el-checkbox>
      </el-checkbox-group>

      <br/>
      <h2>可选项目数量的限制</h2>
      <el-checkbox-group v-model="checkedCities1" :min="1" :max="2">
        <el-checkbox border v-for="city in cities" :label="city" :key="city">{{city}}</el-checkbox>
      </el-checkbox-group>
  </div>
</template>

<script>
const cityOptions = ['上海', '北京', '广州', '深圳']
export default {
  data () {
    return {
      checked: true,
      checked1: false,
      checklist: ['选中且禁用', '复选框A'],

      checkAll: false,
      checkedCities: ['上海', '北京'],
      cities: cityOptions,
      isIndeterminate: true,

      checkedCities1: ['上海', '北京']
    }
  },
  methods: {
    handleCheckAllChange (val) {
      this.checkedCities = val ? cityOptions : []
      this.isIndeterminate = false
    },
    handleCheckedCitiesChange (value) {
      let checkedCount = value.length
      this.checkAll = checkedCount === this.cities.length
      this.isIndeterminate = checkedCount > 0 && checkedCount < this.cities.length
    }
  }
}
</script>
