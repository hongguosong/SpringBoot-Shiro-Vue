<template>
  <div id="container" class="login-container" style="overflow: hidden">
    <!--<div id="container"></div>-->
    <el-form autoComplete="on" :model="loginForm" :rules="loginRules" ref="loginForm" label-position="left"
             label-width="0px"
             class="card-box login-form">
      <h3 class="title">vue学习管理系统</h3>
      <h5 class="title-side">@苏州鸿然</h5>
      <el-form-item prop="username">
        <span class="svg-container svg-container_login">
          <svg-icon icon-class="user"/>
        </span>
        <el-input id="user-name" v-model="loginForm.username" autoComplete="on" @click.native.prevent="onFocus(1)"/>
      </el-form-item>
      <el-form-item prop="password">
        <span class="svg-container">
          <svg-icon icon-class="password"></svg-icon>
        </span>
        <el-input id="user-password" type="password" @keyup.enter.native="handleLogin" v-model="loginForm.password"
                  autoComplete="on" @click.native.prevent="onFocus(2)"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" style="width:100%;" :loading="loading" @click.native.prevent="handleLogin">
          登录
        </el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
  import * as THREE from 'three'
  // import calc from '@/api/haha.js'
  import TrackballControls from '@/api/TrackballControls.js'
  import mountain from '@/images/mountain.jpg'
  import ta from '@/images/ta.png'
  export default {
    name: 'login',
    data() {
      return {
        loginForm: {
          username: 'admin',
          password: '123456'
        },
        loginRules: {
          username: [{required: true, trigger: 'blur', message: "请输入用户名"}],
          password: [{required: true, trigger: 'blur', message: "请输入密码"}]
        },
        loading: false,

        camera: null,
        scene: null,
        renderer: null,
        helper: null,
        mesh: [],
        width: window.innerWidth,
        height: window.innerHeight

      }
    },
    methods: {
      onFocus(a) {
        // var pFocus;
        // if(a === 1){
        //   pFocus = document.getElementById("user-name");
        // } else if (a === 2){
        //   pFocus = document.getElementById("user-password");
        // }
        //
        // pFocus.focus();
        // pFocus.select();
      },
      handleLogin() {
        this.$refs.loginForm.validate(valid => {
          if (valid) {
            this.loading = true
            this.$store.dispatch('Login', this.loginForm).then(data => {
              this.loading = false
              if ("success" === data.result) {
                this.$router.push({path: '/'})
              } else {
                this.$message.error("账号/密码错误");
              }
            }).catch(() => {
              this.loading = false
            })
          } else {
            return false
          }
        })
      },
      onWindowResize() {
        this.width = window.innerWidth;
        this.height = window.innerHeight;
        this.camera.aspect = (this.width) / (this.height);
        this.camera.updateProjectionMatrix();
        this.renderer.setSize( this.width, this.height );
        this.controls.handleResize();
      },
      init: function() {
        let container = document.getElementById('container');
        this.renderer = new THREE.WebGLRenderer({antialias: true});
        this.renderer.setSize(this.width, this.height);
        container.appendChild(this.renderer.domElement);

        this.camera = new THREE.PerspectiveCamera(20, container.clientWidth/(container.clientHeight), 0.01, 10);
        // this.camera.position.set(-2,-4,4);
        this.camera.position.set(-4,3,2);
        this.camera.lookAt(new THREE.Vector3(0, 0, 0));

        this.controls = new TrackballControls( this.camera,  this.renderer.domElement);
        this.controls.rotateSpeed = 5.0;
        this.controls.zoomSpeed = 5;
        this.controls.panSpeed = 2;
        this.controls.noZoom = false;
        this.controls.noPan = false;
        this.controls.staticMoving = false;
        this.controls.dynamicDampingFactor = 0.3;

        this.scene = new THREE.Scene();
        this.scene.add(this.camera);

        // var helper = new THREE.GridHelper( 50, 50 , 0x0000ff, 0x808080);
        // this.scene.add( helper );

        // this.helper = new THREE.GridHelper( 50, 50 , 0x0000ff, 0x808080);
        // this.helper.rotation.x = Math.PI/2;
        // this.scene.add( this.helper );

        //let geometry = new THREE.BoxGeometry(0.2, 0.2, 0.2);
        let geometry =  new THREE.SphereBufferGeometry( 0.13, 132, 116 );
        //let texture = THREE.ImageUtils.loadTexture("src/images/mountain.jpg",null,function(t) { });
        let texture = new THREE.TextureLoader().load(mountain);
        //let material = new THREE.MeshNormalMaterial();
        //let material = new THREE.MeshBasicMaterial({map:texture});
        //let material = new THREE.MeshLambertMaterial( { color: 0xdddddd } );
        //let material = new THREE.MeshBasicMaterial( { color: 0xffaacc, transparent: true, blending: THREE.AdditiveBlending } );
        let material = new THREE.MeshPhongMaterial( { color: 0xdddddd, specular: 0xcccccc, shininess: 3, flatShading: true } )

        // this.mesh = new THREE.Mesh(geometry, material);
        // //this.mesh.position.y = 0.2;
        // this.scene.add(this.mesh);

        //let texture = new THREE.Texture( this.generateTexture() );

        for(var i=-8; i<=8; i++) {
          for(var j=-8; j<=8; j++) {
            //for(var k=-2; k<=2; k++) {
              if( i===1 && j===1) {
                let geometry =  new THREE.SphereBufferGeometry( 0.23, 32, 16 );
                let material = new THREE.MeshLambertMaterial( { map: texture, transparent: true } );
                let mesh = new THREE.Mesh(geometry, material);
                mesh.position.x = i*0.8;
                mesh.position.y = j*0.8;
                this.scene.add(mesh);
                this.mesh.push(mesh);
              } else if(i===0 && j===1) {
                //let texture = THREE.ImageUtils.loadTexture("src/images/ta.png",null,function(t) { });
                let texture = new THREE.TextureLoader().load(ta);
                let geometry =  new THREE.SphereBufferGeometry( 0.23, 32, 16 );
                let material = new THREE.MeshLambertMaterial( { map: texture, transparent: true } );
                let mesh = new THREE.Mesh(geometry, material);
                mesh.position.x = i*0.8;
                mesh.position.y = j*0.8;
                this.scene.add(mesh);
                this.mesh.push(mesh);
              } else if(i===1 && j===0) {
                let geometry =  new THREE.SphereBufferGeometry( 0.23, 15, 15 );
                let material = new THREE.MeshBasicMaterial( { color: 0xffaa00, wireframe: true } );
                let mesh = new THREE.Mesh(geometry, material);
                mesh.position.x = i*0.8;
                mesh.position.y = j*0.8;
                this.scene.add(mesh);
                this.mesh.push(mesh);
              } else if(i===-1 && j===1) {
                let geometry =  new THREE.SphereBufferGeometry( 0.23, 35, 35 );
                let material = new THREE.MeshPhongMaterial( { color: 0x000000, specular: 0x666666, emissive: 0x333333, shininess: 10, opacity: 0.9, transparent: true } );
                let mesh = new THREE.Mesh(geometry, material);
                mesh.position.x = i*0.8;
                mesh.position.y = j*0.8;
                this.scene.add(mesh);
                this.mesh.push(mesh);
              } else if(i===-1 && j===-1){
                // shadow
                var canvas = document.createElement( 'canvas' );
                canvas.width = 2;
                canvas.height = 2;
                var context = canvas.getContext( '2d' );
                var gradient = context.createRadialGradient( canvas.width / 2, canvas.height / 2, 0, canvas.width / 2, canvas.height / 2, canvas.width / 2 );
                gradient.addColorStop( 0.1, 'rgba(210,210,210,1)' );
                gradient.addColorStop( 1, 'rgba(255,255,255,1)' );
                context.fillStyle = gradient;
                context.fillRect( 0, 0, canvas.width, canvas.height );
                var shadowTexture = new THREE.CanvasTexture( canvas );

                let geometry =  new THREE.SphereBufferGeometry( 0.23, 32, 16 );
                let material = new THREE.MeshLambertMaterial( { map: shadowTexture, transparent: true } );
                let mesh = new THREE.Mesh(geometry, material);
                mesh.position.x = i*0.8;
                mesh.position.y = j*0.8;
                this.scene.add(mesh);
                this.mesh.push(mesh);
              }
              else {
                let mesh = new THREE.Mesh(geometry, material);
                mesh.position.x = i*0.8;
                mesh.position.y = j*0.8;
                mesh.position.z = Math.random();
                //mesh.position.z = k*1;
                this.scene.add(mesh);
                if(i===0 && j===0) {

                  this.mesh.push(mesh);
                }
                this.mesh.push(mesh);
              }
           //}
          }
        }

        // Lights
        this.scene.add( new THREE.AmbientLight( 0x222222 ) );
        var directionalLight = new THREE.DirectionalLight( 0xaaaaaa, 0.125 );
        directionalLight.position.x = Math.random() - 0.5;
        directionalLight.position.y = Math.random() - 0.5;
        directionalLight.position.z = Math.random() - 0.5;
        directionalLight.position.normalize();
        this.scene.add( directionalLight );
        this.pointLight = new THREE.PointLight( 0xaaaaaa, 1 );
        this.pointLight.position.z = 5;
        this.scene.add( this.pointLight );

        window.addEventListener( 'resize', this.onWindowResize, false );
      },
      animate: function() {

        var timer = 0.0001 * Date.now();
        this.camera.position.x = Math.cos( timer ) * 2;
        //this.camera.position.y = Math.sin( timer ) * 2;
        this.camera.position.z = Math.sin( timer ) * 2;
        this.camera.lookAt( this.scene.position );
        for ( var i = 0, l = this.mesh.length; i < l; i ++ ) {
          var mesh = this.mesh[ i ];
          mesh.rotation.x += 0.01;
          mesh.rotation.y += 0.005;
        }

        this.pointLight.position.x = Math.sin( timer * 7 ) * 300;
        this.pointLight.position.y = Math.cos( timer * 5 ) * 400;
        this.pointLight.position.z = Math.cos( timer * 3 ) * 300;

        requestAnimationFrame(this.animate);
        this.controls.update();
        this.renderer.render(this.scene, this.camera);
      }
    },
    mounted() {
      this.init()
      this.animate()
    }
  }
</script>
<style rel="stylesheet/scss" lang="scss">
  @import "../../styles/mixin.scss";
  $bg: #2d3a4b;
  $dark_gray: #889aa4;
  $light_gray: #eee;

  .login-container {
    @include relative;
    height: 100vh;
    background-color: $bg;
    input:-webkit-autofill {
      -webkit-box-shadow: 0 0 0px 1000px #293444 inset !important;
      -webkit-text-fill-color: #fff !important;
    }
    input {
      background: transparent;
      border: 0px;
      -webkit-appearance: none;
      border-radius: 0px;
      padding: 12px 5px 12px 15px;
      color: $light_gray;
      height: 47px;
    }
    .el-input {
      display: inline-block;
      height: 47px;
      width: 85%;
    }
    .tips {
      font-size: 14px;
      color: #fff;
      margin-bottom: 10px;
    }
    .svg-container {
      padding: 6px 5px 6px 15px;
      color: $dark_gray;
      vertical-align: middle;
      width: 30px;
      display: inline-block;
      &_login {
        font-size: 20px;
      }
    }
    .title {
      font-size: 26px;
      color: $light_gray;
      margin: 0px auto 10px auto;
      text-align: center;
      font-weight: bold;
    }
    .title-side {
      margin: 0px auto 40px auto;
      text-align: center;
      color: white;
    }
    .login-form {
      position: absolute;
      top: 0;
      left: 0;
      right: 0;
      width: 400px;
      padding: 35px 35px 15px 35px;
      margin: 120px auto;
      z-index: 1000000;
    }
    .el-form-item {
      border: 1px solid rgba(255, 255, 255, 0.1);
      background: rgba(0, 0, 0, 0.1);
      border-radius: 5px;
      color: #454545;
    }
    .show-pwd {
      position: absolute;
      right: 10px;
      top: 7px;
      font-size: 16px;
      color: $dark_gray;
      cursor: pointer;
    }
    .thirdparty-button {
      position: absolute;
      right: 35px;
      bottom: 28px;
    }
  }

</style>
