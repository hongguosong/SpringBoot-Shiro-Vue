<template>
    <ul>
        <li v-for="todo in todos" v-bind:key="todo.id">
            <slot v-bind:todo="todo">
                {{todo.text}}
            </slot>
        </li>
    </ul>
</template>

<script>
export default {
  props: ['todos']
}
</script>
