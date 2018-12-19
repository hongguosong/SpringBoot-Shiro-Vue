<template>
  <div id="transfer">
      {{value1}}
      <el-transfer v-model="value1" :data="data"></el-transfer>

      <br/>
      <br/>
      <el-transfer
        filterable
        :filter-method="filterMethod"
        filter-placeholder="请输入城市拼音"
        v-model="value2"
        :data="data2">
      </el-transfer>
  </div>
</template>

<script>
export default {
  data () {
    const generateData = _ => {
      const data = []
      for (let i = 1; i <= 15; i++) {
        data.push({
          key: i * 10 + '',
          label: '备选项' + i * 10,
          disabled: i * 10 % 4 === 0
        })
      }
      return data
    }

    const generateData2 = _ => {
      const data = []
      const cities = ['上海', '北京', '广州', '深圳']
      const pinyin = ['shanghai', 'beijing', 'guangzhou', 'shengzheng']
      cities.forEach((city, index) => {
        data.push({
          label: city,
          key: index,
          pinyin: pinyin[index]
        })
      })
      return data
    }

    return {
      data: generateData(),
      data2: generateData2(),
      value1: ['10', '40'],
      value2: [],
      filterMethod (query, item) {
        return item.pinyin.indexOf(query) > -1
      }
    }
  }
}
</script>
