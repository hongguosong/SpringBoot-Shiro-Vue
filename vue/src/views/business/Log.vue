<template>
  <div id="log">
    <el-card>
      <div slot="header">
        <span>Log List >> </span>
        <span>{{currentPath}}</span>
        <div style="display: inline-block; float: right">
          <span>select line: </span>
          <el-select v-model="lcServerIp" placeholder="请选择线体编号" size="mini" @change="onLineChange">
            <el-option
              v-for="item in agingLines"
              :key="item.id"
              :label="item.id"
              :value="item.lcServerIp">
            </el-option>
          </el-select>
        </div>
      </div>
      <div style="width: 100%; height: 280px; margin-left: 50px; overflow: auto;" v-loading="fileLoading">
        <div class="box_base" v-if="parentName !== 'Root'" :style="{background: goBackpng}" @dblclick="goBack"></div>
        <div v-for="item in logFileResult.children" :key="item.name" class="box_base" :style="item.directory ? dirBackground : logBackground"
          @mouseenter="enter(item)" @mouseleave="leave(item)" @click="setCurrentFile(item)">
          <div class="box_downLoad" v-if="item.show && !item.directory">
            <a class="box_downLoad_icon" v-if="!item.directory" :href="remoteSite+'AgLCLog/download?fullName='+encodeFullPath(item.fullPath)">
              <div style="margin-left: 56px; width: 24px; height: 24px; border-radius: 15px; background: #fff;" :style="{background: downloadpng}">
                <!-- <i class="el-icon-download"></i> -->
                <!-- <img :src="downloadpng" /> -->
              </div>
            </a>
            <div class="box_size_icon">{{item.directory ? "" : item.size}}</div>
          </div>
          <div class="box_downLoad" v-else @dblclick="goChild(item)"></div>
          <!-- <el-tooltip :content="item.name" placement="bottom" effect="light">
            <div class="box_name">{{item.name}}</div>
          </el-tooltip> -->
          <el-popover
            popper-class="popover-this"
            placement="bottom-start"
            trigger="hover"
            :content="item.name">
            <div class="box_name" slot="reference">{{item.name}}</div>
          </el-popover>
        </div>
      </div>
    </el-card>
    <el-card>
      <div slot="header">
        <span>Log >></span>
        <span>{{currentSelectPath}}</span>
        <div style="display: inline-block; float: right">
          <el-radio-group v-model="logFileRequestDetails.orderBy" @change="topBottomChg">
            <el-radio :label="0">FromTop</el-radio>
            <el-radio :label="1">FromBottom</el-radio>
          </el-radio-group>
          <el-button type="primary" round size="mini" style="margin-left: 10px;" :loading="loadingShowBtn" @click="showText">{{showButtonText}}</el-button>
        </div>
      </div>
      <div style="width: 100%; overflow: auto;" :style="{height: logHeight}" v-html="logText">
      </div>
    </el-card>
  </div>
</template>

<script>
import iconGoBack from '@/images/go-back.png'
import iconDirect from '@/images/directoryico.png'
import iconLogfile from '@/images/logfileico.png'
import download from '@/images/download.png'
import { encode } from '@/utils/base64'
export default {
  data () {
    return {
      goBackpng: 'url(' + iconGoBack + ')',
      downloadpng: 'url(' + download + ')',
      logBackground: {
        background: 'url(' + iconLogfile + ')'
      },
      dirBackground: {
        background: 'url(' + iconDirect + ')'
      },
      showDownLoad: false,
      fileLoading: false,

      currentPath: 'show Log of list',
      currentSelectPath: '-',
      lcServerIp: '',
      agingLines: [],
      logFileResult: [],
      // { children: [
      //   { name: 'ui', size: '9o', directory: true, show: false },
      //   { name: 'op', size: '0.9kb', directory: false, show: false }
      // ] },
      logFileParent: null,

      loadingShowBtn: false,
      logHeight: ((window.innerHeight - 600) < 200 ? 200 : (window.innerHeight - 600)) + 'px',
      logText: '',
      logFileRequestDetails: {
        start: 0,
        count: 100,
        orderBy: 0,
        logFile: ''
      }
    }
  },
  computed: {
    remoteSite: function () {
      return 'http://' + this.lcServerIp + ':8066/'
    },
    parentName: function () {
      if (this.logFileParent) {
        return this.logFileParent.name
      } else {
        return 'Root'
      }
    },
    showButtonText: function () {
      if (this.logFileRequestDetails.start > 0) {
        return 'More...'
      } else {
        return 'Show'
      }
    }
  },
  methods: {
    topBottomChg: function () {
      this.logFileRequestDetails.start = 0
      this.logText = ''
    },
    onWindowResize: function () {
      this.logHeight = ((window.innerHeight - 600) < 200 ? 200 : (window.innerHeight - 600)) + 'px'
      console.log(this.logHeight)
    },
    setCurrentFile: function (item) {
      this.currentSelectPath = item.fullPath
      this.logFileRequestDetails.logFile = item
      this.logFileRequestDetails.start = 0
      this.logText = ''
    },
    goBack: function () {
      this.logText = ''
      var that = this
      this.api({
        method: 'post',
        url: this.remoteSite + 'AgLCLog/goback',
        data: this.logFileParent,
        contentType: 'application/json; charset=utf-8'
      }).then(data => {
        that.logFileResult = data
        that.logFileParent = that.logFileResult.parent
        that.currentPath = that.logFileParent.fullPath
      })
    },
    goChild: function (item) {
      this.logFileRequest = item
      this.init()
    },
    encodeFullPath: function (fullPath) {
      return encode(fullPath)
    },
    enter: function (item) {
      for (var i = 0; i < this.logFileResult.children.length; i++) {
        if (this.logFileResult.children[i].name === item.name) {
          this.logFileResult.children[i].show = true
        }
      }
    },
    leave: function (item) {
      for (var i = 0; i < this.logFileResult.children.length; i++) {
        if (this.logFileResult.children[i].name === item.name) {
          this.logFileResult.children[i].show = false
        }
      }
    },
    initLines: function () {
      this.api({
        url: '/AgMonitor/AgLines?id=' + 0,
        method: 'get'
      }).then(data => {
        this.agingLines = data.list
        for (var i = 0; i < this.agingLines.length; i++) {
          this.lcServerIp = this.agingLines[0].lcServerIp
          this.init()
          break
        }
      })
    },
    init: function () {
      this.logText = ''
      this.fileLoading = true
      var that = this
      this.api({
        method: 'post',
        url: this.remoteSite + 'AgLCLog/listLog',
        data: this.logFileRequest,
        contentType: 'application/json; charset=utf-8'
      }).then(data => {
        that.logFileResult = data
        that.logFileParent = that.logFileResult.parent
        that.currentPath = that.logFileParent.fullPath

        that.fileLoading = false
      }).catch(data => {
        that.fileLoading = false
      })
    },
    onLineChange: function () {
      this.init()
    },
    showText: function () {
      if (!this.logFileRequestDetails.logFile.directory && this.currentSelectPath !== '-') {
        this.loadingShowBtn = true
        var that = this
        this.api({
          method: 'post',
          url: this.remoteSite + 'AgLCLog/showContent?newline=1',
          data: this.logFileRequestDetails,
          contentType: 'application/json; charset=utf-8'
        }).then(data => {
          if (that.logFileRequestDetails.orderBy === 0) {
            that.logText = that.logText + data
          } else {
            that.logText = data + that.logText
          }
          that.logFileRequestDetails.start = that.logFileRequestDetails.start + that.logFileRequestDetails.count
          that.loadingShowBtn = false
        }).catch(data => {
          that.loadingShowBtn = false
        })
      } else {
        this.$message({
          message: '请先选择一个文件',
          type: 'warning'
        })
      }
    }
  },
  mounted () {
    window.addEventListener('resize', this.onWindowResize, false)
    this.initLines()
  }
}
</script>

<style>
.box_base {
  width: 130px;
  height: 130px;
  /* display: inline-block; */
  float: left;
  border: 1px solid #aaa;
  margin: 2px;
  /* padding: 5px; */
}
.box_downLoad :hover {
  background-color: rgba(100, 100, 100, 0.5)
}
.box_downLoad {
  width: 128px;
  height: 112px;
}
.box_downLoad_icon {
  width: 128px;
  height: 17px;
}
.box_size_icon {
  width: 128px;
  height: 96px;
  padding: 30px 0;
  text-align: center;
  color: white;
}
.box_name {
  width: 128px;
  height: 18px;
  text-align: center;
  background-color:cornflowerblue;
  color: white;
  float: bottom right;
  overflow:hidden;  /*超过部分不显示*/
  text-overflow:ellipsis;  /*超过部分用点点表示*/
  white-space:nowrap;/*不换行*/
}
#log .el-card__header {
  padding: 18px 20px;
}
/* .el-card__body {
  padding: 10px;
} */

/* #log .el-popover--plain {
  padding: 0;
} */
.popover-this {
  padding: 3px;
}
</style>
