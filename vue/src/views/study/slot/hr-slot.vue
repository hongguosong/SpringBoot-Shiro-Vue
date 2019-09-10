<template>
  <base-layout>
    <h1 slot="header">这里是头部</h1>
    <navigation-link url="/study/button">
      Go to study button
      <span class="dd">haha</span>
    </navigation-link>
    <font-awesome-icon name="device"></font-awesome-icon>
    <submit-button>Test</submit-button>
    <todo-list v-bind:todos="todos">
      <!--将slotScope定义为插槽作用域的名字-->
      <template slot-scope="slotScope">
        <span v-if="slotScope.todo.isCompleted">√</span>
        {{slotScope.todo.text}}
      </template>
    </todo-list>
    <template slot="footer">这里是底部</template>
  </base-layout>
</template>

<script>
import BaseLayout from './base-layout'
import MyComponent from './navigation-link'
import FontAwesomeIcon from './font-awesome-icon'
import SubmitButton from './submit-button'
import TodoList from './todo-list'
export default {
  name: 'my-slot',
  components: {
    'base-layout': BaseLayout,
    'navigation-link': MyComponent,
    'font-awesome-icon': FontAwesomeIcon,
    'submit-button': SubmitButton,
    'todo-list': TodoList
  },
  data () {
    return {
      todos: [
        { id: 1, text: 'apple', isCompleted: true },
        { id: 2, text: 'banana', isCompleted: false }
      ]
    }
  }
}
</script>

<style scoped>
 .dd {
   font-weight: 600;
   font-size: 50px;
 }
</style>
