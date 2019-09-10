// 引入mockjs
const Mock = require('mockjs')
// 获取 mock.Random 对象
const Random = Mock.Random
// mock一组数据
const produceCarFlowData = function () {
  return {
    inCar: Random.natural(60, 100),
    outCar: Random.natural(60, 100),
    abnormalCar: Random.natural(60, 100)
  }
}

// Mock.mock( url, post/get , 返回的数据)；
Mock.mock('/api/flow/getCarFlow', 'get', produceCarFlowData)
