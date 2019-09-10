<template>
    <div class="posts-tab">
        <ul class="posts-sidebar">
            <li v-for="post in posts" v-bind:key="post.id"
                v-bind:class="{selected: post===selectedPost}"
                v-on:click="selectedPost = post">
                {{post.title}}
            </li>
        </ul>
        <div class="selected-post-container">
            <div v-if="selectedPost" class="selected-post">
                <h3>{{selectedPost.title}}</h3>
                <div v-html="selectedPost.content"></div>
            </div>
            <strong v-else>
                Click on a blog title to the left to view a post.
            </strong>
        </div>
    </div>
</template>

<script>
export default {
  data () {
    return {
      posts: [
        { id: 1, title: 'cat', content: 'Cat' },
        { id: 2, title: 'dog', content: 'dog' },
        { id: 3, title: 'apple', content: 'apple' }
      ],
      selectedPost: null
    }
  }
}
</script>
