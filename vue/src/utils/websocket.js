import SockJS from 'sockjs-client'
import Stomp from 'stompjs'

export default {
  client: null,
  socket: null,
  connectCallback: null,
  closeCallback: null,
  timer: '',
  flag: false,
  connect: function () {
    this.socket = new SockJS('http://localhost:8080/gs-guide-websocket', {origins: 'http://127.0.0.1:9520'})
    this.client = Stomp.over(this.socket)
    let that = this
    var headers = {
      login: 'mylogin',
      passcode: 'mypasscode',
      // additional header
      'client-id': 'my-client-id'
    };
    this.client.connect(headers, function (frame) {
      that.client.subscribe('/topic/hello', function (data) {
        // let jsoneData = JSON.parse(data.body)
        console.log(data.body)
      })
      if (typeof that.connectCallback === 'function') {
        that.connectCallback(that.client)
      }
    }, function (frame) {
      // console.log(frame)
      // console.error(new Date() + 'websocket失去连接')
    })
  },
  setConnectCallback: function (fn) {
    this.connectCallback = fn
  },
  setCloseCallback: function (fn) {
    this.closeCallback = fn
  },
  consume: function (raw) {
    console.log(raw)
  },
  close: function () {
    if (this.client !== null && this.client !== undefined) {
      if (typeof this.closeCallback === 'function') {
        this.closeCallback(this.client)
      }
      this.client.unsubscribe('/topic/hello')
      this.client.disconnect()
      this.client = null
    }
    clearInterval(this.timer)
  },
  initWebSocket: function () {
    this.connect()
    // let that = this
    // this.timer = setInterval(() => {
    //   try {
    //     that.client.send('test')
    //   } catch (err) {
    //     console.log('断线了' + err)
    //     that.connect()
    //   }
    // }, 100000)
  }
}
