<template>
  <div id="time">
      <h5>---------------时间选择</h5>
      <h2>固定时间点</h2>
      <el-time-select
        v-model="value1"
        :picker-options = "{
          stasrt: '08:30',
          step: '00:15',
          end: '18:30'
        }"
        placeholder="选择时间">
      </el-time-select>

      <br/>
      <br/>
      <h2>任意时间点</h2>
      <el-time-picker
        v-model="value2"
        :picker-options = "{
          selectableRange: '18:30:00 - 20:30:00'
        }"
        placeholder="任意时间">
      </el-time-picker>
      <span> - </span>
      <el-time-picker
        v-model="value3"
        :picker-options = "{
          selectableRange: '18:30:00 - 20:30:00'
        }"
        placeholder="任意时间">
      </el-time-picker>

      <br/>
      <br/>
      <h2>选择时间范围</h2>
      <el-time-picker
        is-range
        v-model="value4"
        range-separator = "-"
        start-placeholder="开始时间"
        end-placeholder = "结束时间"
        placeholder = "选择时间范围"
        @change="handleChange">
        </el-time-picker>

        <br/>
        <br/>
        <br/>
        <br/>
        <h5>---------------日期选择</h5>
        <el-rate
          v-model="value5"
          show-score
          allow-half
          text-color="#ff9900"
          score-template="{value}">
        </el-rate>

        <br/>
        <br/>
        <el-color-picker v-model="color1" show-alpha></el-color-picker>
        <br/>{{color1}}
  </div>
</template>

<script>
export default {
  data () {
    return {
      value1: '',
      value2: new Date(2016, 9, 10, 12, 34),
      value3: new Date(2016, 9, 10, 12, 34),
      value4: [new Date(2016, 9, 10, 12, 34), new Date(2016, 9, 10, 13, 34)],
      value5: 3.5,
      color1: 'rgba(19, 206, 102, 0.8)'
    }
  },
  methods: {
    handleChange (val) {
      console.log(val)
    }
  }
}
</script>
