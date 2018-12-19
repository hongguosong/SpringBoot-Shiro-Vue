<template>
  <div id="select">
      <h2>基础用法</h2>
      <el-select v-model="value" placeholder="请选择" @change="handleChange" clearable >
        <el-option v-for="item in options" :key="item.value" :label="item.label" :value="item.value" :disabled="item.disabled"></el-option>
      </el-select>

      <br/>
      <h2>基础多选</h2>
      <el-select multiple  collapse-tags v-model="value5" placeholder="请选择">
        <el-option v-for="item in options" :key="item.value" :label="item.label" :value="item.value">
          <span style="float: left">{{ item.label }}</span>
          <span style="float: right; color: #8492a6; font-size: 13px">{{ item.value }}</span>
        </el-option>
      </el-select>

      <br/>
      <h2>分组</h2>
      <el-select filterable  v-model="value7" placeholder="请选择">
        <el-option-group
          v-for="group in options3"
          :key="group.label"
          :label="group.label">
          <el-option
            v-for="item in group.options"
            :key="item.value"
            :label="item.label"
            :value="item.value">
          </el-option>
        </el-option-group>
      </el-select>
  </div>
</template>

<script>
export default {
  data () {
    return {
      options: [
        { value: '1', label: '黄金糕' },
        { value: '2', label: '龙须面', disabled: true }
      ],
      options3: [
        {
          label: '热门城市',
          options: [
            {
              value: 'shanghai',
              label: '上海'
            },
            {
              value: 'beijing',
              label: '北京'
            }
          ]
        },
        {
          label: '城市名',
          options: [
            {
              value: 'chengdu',
              label: '成都'
            },
            {
              value: 'dalian',
              label: '大连'
            }
          ]
        }
      ],
      value: '',
      value5: [],
      value7: ''
    }
  },
  methods: {
    handleChange (val) {
      console.log(val)
    }
  }
}
</script>

<style>

</style>
