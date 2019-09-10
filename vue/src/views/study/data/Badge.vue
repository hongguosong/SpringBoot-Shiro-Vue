<template>
  <div id="badge">
    <el-badge :value="12" class="item">
      <el-button size="small">评论</el-button>
    </el-badge>
    <el-badge :value="2" class="item">
      <el-button size="small">回复</el-button>
    </el-badge>

    <el-dropdown trigger="click" class="item">
      <span class="el-dropdown-link">
        点我查看<i class="el-icon-caret-bottom el-icon-right"></i>
      </span>
      <el-dropdown-menu slot="dropdown">
        <el-dropdown-item class="clearfix">
          评论
          <el-badge class="mark" :value="12" />
        </el-dropdown-item>
        <el-dropdown-item class="clearfix">
          回复
          <el-badge class="mark" :value="3" />
        </el-dropdown-item>
      </el-dropdown-menu>
    </el-dropdown>

    <el-badge :value="200" :max="99" class="item">
      <el-button size="small">评论</el-button>
    </el-badge>
    <el-badge value="new" class="item">
      <el-button size="small">回复</el-button>
    </el-badge>

    <el-badge is-dot class="item">数据查询</el-badge>
    <el-badge is-dot class="item">
      <el-button class="share-button" icon="el-icon-share" type="primary" size="mini"></el-button>
    </el-badge>
  </div>
</template>

<style>
  .item{
    margin-left: 20px;
  }
  .mark{
    margin-left: 5px;
    margin-top: 7px;
  }
  .share-button{

  }
</style>
