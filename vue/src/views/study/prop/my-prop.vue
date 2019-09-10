<template>
  <div>
    <div v-bind:style="{fontSize: postFontSize + 'em'}">
      <blog-post v-bind:post="post" v-on:enlarge-text="postFontSize += $event"></blog-post>
      <blog-post v-for="post in posts" v-bind:key="post.id" v-bind:post="post" v-on:enlarge-text="postFontSize -= $event"></blog-post>
    </div>

    <base-input v-bind:label="post.author.title" v-model="post.title" class="put"
        test="test1234" v-bind:placeholder="placeholder" style="margin-top: 20px;"></base-input>
    <base-checkbox v-model="lovingVue">apple</base-checkbox>
    <my-event></my-event>
    <el-button v-on:click="warn('Form cannot be submitted yet.', $event)">
      Submit
    </el-button>
    <input v-on:keyup.enter="submit" v-model="inputText">{{inputText}}
    <dynamic-component></dynamic-component>
    <router-link to="/notice/alert">Go to Foo</router-link>
    <router-view></router-view>

    <div>
      <el-input
        type="textarea"
        placeholder="请输入内容"
        v-model="textarea"
        :rows="20"
        style="width: 500px;">
      </el-input>
    </div>
  </div>
</template>

<script>
import BlogPost from './blog-post'
import BaseInput from './base-input'
import MyEvent from '../event/my-event'
import DynamicComponent from './dynamic-component'
import BaseCheckBox from '../event/base-checkbox'
export default {
  name: 'my-prop',
  components: {
    'blog-post': BlogPost,
    'base-input': BaseInput,
    'my-event': MyEvent,
    'dynamic-component': DynamicComponent,
    'base-checkbox': BaseCheckBox
  },
  data () {
    return {
      post: {
        title: 'test',
        likes: 12,
        isPublished: true,
        commentIds: [12, 13, 14],
        author: {
          name: 'hongguosong',
          title: '$attrs存储非prop特性，inheritAttrs控制vue对非prop特性默认行为'
        }
      },
      posts: [ {
        title: 'haha',
        likes: 11112,
        isPublished: true,
        commentIds: [12, 13, 14],
        author: {
          name: 'haha',
          title: '$attrs存储非prop特性，inheritAttrs控制vue对非prop特性默认行为'
        }
      } ],
      placeholder: 'Enter your username',
      textarea: '',
      postFontSize: 1,
      lovingVue: true,
      inputText: ''
    }
  },
  methods: {
    test: function () {
      // const requireAll = requireContext => requireContext.keys.map(requireContext)
      // const req = () => {return {keys:[1,2,3,4]}}
      // console.log(requireAll(req))
      var a = function () {
        return {
          keys: [1, 2, 3, 4]
        }
      }
      var b = c => c().keys.map(c)
      console.log(a.keys)
      console.log(b(a))
    },
    memoize: function (func) {
      var cache = {}
      return function () {
        var key = arguments[0]
        if (cache[key]) {
          return cache[key]
        } else {
          var val = func.apply(this, arguments)
          cache[key] = val
          return val
        }
      }
    },
    warn: function (message, event) {
      // 现在我们可以访问原生事件对象
      if (event) event.preventDefault()
      alert(message)
    },
    submit: function () {
      alert(this.inputText)
    }
  },
  mounted () {
    this.test()
    var that = this
    this.websocket.setConnectCallback(function (client) {
      client.subscribe('/topic/tick', function (data) {
        // let jsoneData = JSON.parse(data.body)
        that.post.title = data.body
        that.textarea += (data.body + '\n')
        console.log(data.body)
      })
    })
    this.websocket.setCloseCallback(function (client) {
      client.unsubscribe('/topic/tick')
    })
    this.websocket.initWebSocket()

    var fibonacci = this.memoize(function (n) {
      return (n === 0 || n === 1) ? n : fibonacci(n - 1) + fibonacci(n - 2)
    })
    console.log(fibonacci(100))
    console.log(fibonacci(100))

    var fx = function (func) {
      return func.apply(this, arguments)
    }
    //    var out = fx(function (x) {
    //         var y = x + 1
    //         return function() {
    //             return y
    //         }
    //     })

    //     console.log(out(1))

    fx(a => console.log(a))

    var hh = {
      jk: function (a) {
        console.log(a)
      }
    }

    hh.jk.call(this, 'arguments')
    fx(hh.jk)
  },
  beforeDestroy () {
    this.websocket.close()
  }
}

</script>

<style lang="scss" scoped>
    .put {
        color: red;
        border: 10px red solid;
    }
</style>
