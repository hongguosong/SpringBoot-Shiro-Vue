<template>
<div>
  <div class="container">
    <!-- 模态框 -->

    <div class="modal fade" id="myModal">
      <div class="modal-dialog modal-lg">
        <div class="modal-content" style="">
          <!-- 模态框头部 -->

          <div class="modal-header">
            <h4 class="modal-title">Pallets 产能</h4>
            <button type="button" class="close" data-dismiss="modal">&times;</button>
          </div>

          <!-- 模态框主体 -->

          <div class="modal-body">
            <table class="table table-sm" id="palletsDay" style="height:450px">
              <thead>
                <tr>
                  <th>Time</th>
                  <th>08</th>
                  <th>09</th>
                  <th>10</th>
                  <th>11</th>
                  <th>12</th>
                  <th>13</th>
                  <th>14</th>
                  <th>15</th>
                  <th>16</th>
                  <th>23</th>
                  <th>24</th>
                  <th>25</th>
                  <th>26</th>
                  <th>27</th>
                </tr>
              </thead>

              <tbody>
                <tr v-for="item in palletsDayObj" v-bind:key="item.time">
                  <th v-text="item.time"></th>

                  <td v-text="item.l8"></td>

                  <td v-text="item.l9"></td>

                  <td v-text="item.l10"></td>

                  <td v-text="item.l11"></td>

                  <td v-text="item.l12"></td>

                  <td v-text="item.l13"></td>

                  <td v-text="item.l14"></td>

                  <td v-text="item.l15"></td>

                  <td v-text="item.l16"></td>

                  <td v-text="item.l23"></td>

                  <td v-text="item.l24"></td>

                  <td v-text="item.l25"></td>

                  <td v-text="item.l26"></td>

                  <td v-text="item.l27"></td>
                </tr>
              </tbody>
            </table>
          </div>

          <!-- 模态框底部 -->

          <div class="modal-footer">
            UserAlarm
            <a href="userAlarm.html" style="width: 20px; height: 20px;margin-right: 50px;margin-bottom: 5px;margin-left: 5px;">
              <img src="assets/img/cog.svg" style="width: 20px; height: 20px;" />
            </a>

            <span style="margin-right: 450px;">
              DotPop
              <input id="popAlarmSetting" type="checkbox" style="margin-left: 0px;" />
            </span>
            <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
          </div>
        </div>
      </div>
    </div>
  </div>

  <div hidden="hidden">
    <svg xmlns="http://www.w3.org/2000/svg" xmlns:svg="http://www.w3.org/2000/svg" height="0" width="0">
      <symbol id="ohc">
        <title>OHC</title>

        <rect fill="none" stroke="#aaa" stroke-width="5" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x="0" y="0" width="140" height="85" id="svg_1"></rect>

        <line fill="none" stroke="#aaa" stroke-width="4" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x1="0" y1="25" x2="140" y2="25" id="svg_2"></line>

        <line fill="none" stroke="#aaa" stroke-width="4" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x1="0" y1="60" x2="140" y2="60" id="svg_3"></line>
      </symbol>

      <symbol id="assy">
        <desc>Assy Section</desc>

        <rect fill="none" stroke="#aaa" stroke-width="5" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x="0" y="0" width="105" height="100" id="svg_3"></rect>

        <rect id="svg_29" height="56.75" width="101.42291" y="18" x="2.25" stroke-linecap="null" stroke-linejoin="null" stroke-dasharray="null" stroke-width="5" fill="none" stroke="#999"></rect>

        <line id="svg_30" y2="49.75" x2="103.22206" y1="49.75" x1="2.53896" stroke-linecap="null" stroke-linejoin="null" stroke-dasharray="null" stroke-width="5" fill="none" stroke="#999"></line>

        <line id="svg_31" y2="73" x2="19.73173" y1="51" x1="19.73173" stroke-linecap="null" stroke-linejoin="null" stroke-dasharray="null" stroke-width="5" fill="none" stroke="#999"></line>

        <line id="svg_32" y2="74" x2="44.58178" y1="50.5" x1="44.58178" stroke-linecap="null" stroke-linejoin="null" stroke-dasharray="null" stroke-width="5" fill="none" stroke="#999"></line>

        <line id="svg_33" y2="74.31507" x2="69.28736" y1="50.75" x1="69.28736" stroke-linecap="null" stroke-linejoin="null" stroke-dasharray="null" stroke-width="5" fill="none" stroke="#999"></line>

        <line id="svg_34" y2="73.75134" x2="87.78043" y1="50.5" x1="87.78043" stroke-linecap="null" stroke-linejoin="null" stroke-dasharray="null" stroke-width="5" fill="none" stroke="#999"></line>

        <line id="svg_35" y2="82.50446" x2="10.34071" y1="75.5" x1="10.34071" stroke-linecap="null" stroke-linejoin="null" stroke-dasharray="null" stroke-width="5" fill="none" stroke="#999"></line>

        <line id="svg_36" y2="81.75446" x2="13.37474" y1="74.75" x1="13.37474" stroke-linecap="null" stroke-linejoin="null" stroke-dasharray="null" stroke-width="5" fill="none" stroke="#999"></line>

        <line id="svg_37" y2="82.50417" x2="52.23907" y1="75" x1="52.23907" stroke-linecap="null" stroke-linejoin="null" stroke-dasharray="null" stroke-width="5" fill="none" stroke="#999"></line>

        <line id="svg_38" y2="82.53869" x2="55.1286" y1="75.25" x1="55.1286" stroke-linecap="null" stroke-linejoin="null" stroke-dasharray="null" stroke-width="5" fill="none" stroke="#999"></line>

        <line id="svg_39" y2="82.75403" x2="92.9816" y1="75" x1="92.9816" stroke-linecap="null" stroke-linejoin="null" stroke-dasharray="null" stroke-width="5" fill="none" stroke="#999"></line>

        <line id="svg_40" y2="82.5" x2="96.01563" y1="74.75" x1="96.01563" stroke-linecap="null" stroke-linejoin="null" stroke-dasharray="null" stroke-width="5" fill="none" stroke="#999"></line>

        <rect id="svg_44" height="7" width="8.8131" y="83" x="7.45118" stroke-linecap="null" stroke-linejoin="null" stroke-dasharray="null" stroke-width="5" fill="none" stroke="#999"></rect>

        <rect id="svg_45" height="7" width="8.95758" y="83" x="49.06057" stroke-linecap="null" stroke-linejoin="null" stroke-dasharray="null" stroke-width="5" fill="none" stroke="#999"></rect>

        <rect id="svg_46" height="7" width="8.8131" y="83" x="90.23654" stroke-linecap="null" stroke-linejoin="null" stroke-dasharray="null" stroke-width="5" fill="none" stroke="#999"></rect>
      </symbol>

      <symbol id="autoTape">
        <title>AUTO TAPE</title>

        <rect fill="none" stroke="#aaa" stroke-width="5" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x="0" y="0" width="165" height="85" id="svg_2"></rect>

        <rect fill="none" stroke="#aaa" stroke-width="4" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x="7.25" y="0" width="35" height="38" id="svg_2"></rect>

        <rect fill="none" stroke="#aaa" stroke-width="4" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x="7.25" y="44.0127" width="35" height="38" id="svg_2"></rect>

        <rect fill="none" stroke="#aaa" stroke-width="4" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x="48" y="0" width="35" height="38" id="svg_2"></rect>

        <rect fill="none" stroke="#aaa" stroke-width="4" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x="48" y="44.0127" width="35" height="38" id="svg_2"></rect>

        <rect fill="none" stroke="#aaa" stroke-width="4" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x="90" y="0" width="35" height="38" id="svg_2"></rect>

        <rect fill="none" stroke="#aaa" stroke-width="4" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x="90" y="44.0127" width="35" height="38" id="svg_2"></rect>

        <rect fill="none" stroke="#aaa" stroke-width="4" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x="130" y="0" width="35" height="38" id="svg_2"></rect>

        <rect fill="none" stroke="#aaa" stroke-width="4" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x="130" y="44.0127" width="35" height="38" id="svg_2"></rect>
      </symbol>

      <symbol id="assyTest">
        <desc>Assy Test Section</desc>

        <rect fill="none" stroke="#aaa" stroke-width="5" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x="0" y="0" width="100" height="100" id="svg_1"></rect>

        <rect stroke="#999" id="svg_2" height="38" width="20.43306" y="44.0127" x="4.84373" stroke-linecap="null" stroke-linejoin="null" stroke-dasharray="null" stroke-width="2" fill="none"></rect>

        <rect stroke="#999" id="svg_4" height="38.25" width="20.43306" y="44" x="4.84373" stroke-linecap="null" stroke-linejoin="null" stroke-dasharray="null" stroke-width="2" fill="none"></rect>

        <rect stroke="#999" id="svg_5" height="33.75" width="15.47075" y="48.4873" x="7.32488" stroke-linecap="null" stroke-linejoin="null" stroke-dasharray="null" stroke-width="2" fill="none"></rect>

        <line stroke="#999" id="svg_6" y2="54" x2="22.52897" y1="54" x1="7.32488" stroke-linecap="null" stroke-linejoin="null" stroke-dasharray="null" stroke-width="2" fill="none"></line>

        <line stroke="#999" id="svg_7" y2="77.75" x2="7.19831" y1="77.75" x1="4.98968" stroke-linecap="null" stroke-linejoin="null" stroke-dasharray="null" stroke-width="2" fill="none"></line>

        <line stroke="#999" id="svg_9" y2="78.5" x2="24.98974" y1="78.5" x1="22.79563" stroke-linecap="null" stroke-linejoin="null" stroke-dasharray="null" stroke-width="2" fill="none"></line>

        <line stroke="#999" id="svg_11" y2="44" x2="95.43844" y1="44" x1="24.98489" stroke-linecap="null" stroke-linejoin="null" stroke-dasharray="null" stroke-width="2" fill="none"></line>

        <rect stroke="#999" id="svg_12" height="38.25" width="20.43306" y="43.7627" x="28.34175" stroke-linecap="null" stroke-linejoin="null" stroke-dasharray="null" stroke-width="2" fill="none"></rect>

        <rect stroke="#999" id="svg_13" height="38.5" width="20.28711" y="43.75" x="51.69382" stroke-linecap="null" stroke-linejoin="null" stroke-dasharray="null" stroke-width="2" fill="none"></rect>

        <rect stroke="#999" id="svg_14" height="38.75" width="20.14116" y="43.75" x="75.33779" stroke-linecap="null" stroke-linejoin="null" stroke-dasharray="null" stroke-width="2" fill="none"></rect>

        <rect stroke="#999" id="svg_15" height="34.25" width="15.3248" y="47.77539" x="30.8229" stroke-linecap="null" stroke-linejoin="null" stroke-dasharray="null" stroke-width="2" fill="none"></rect>

        <rect stroke="#999" id="svg_16" height="33.75" width="15.17884" y="48.25" x="54.32092" stroke-linecap="null" stroke-linejoin="null" stroke-dasharray="null" stroke-width="2" fill="none"></rect>

        <rect stroke="#999" id="svg_17" height="34" width="14.88694" y="48.25" x="77.96489" stroke-linecap="null" stroke-linejoin="null" stroke-dasharray="null" stroke-width="2" fill="none"></rect>

        <line stroke="#999" id="svg_18" y2="54.25" x2="46.15401" y1="54.25" x1="30.96885" stroke-linecap="null" stroke-linejoin="null" stroke-dasharray="null" stroke-width="2" fill="none"></line>

        <line stroke="#999" id="svg_19" y2="54.25" x2="69.5026" y1="54.25" x1="54.46687" stroke-linecap="null" stroke-linejoin="null" stroke-dasharray="null" stroke-width="2" fill="none"></line>

        <line stroke="#999" id="svg_20" y2="54" x2="93.03388" y1="54" x1="77.96489" stroke-linecap="null" stroke-linejoin="null" stroke-dasharray="null" stroke-width="2" fill="none"></line>

        <line stroke="#999" id="svg_21" y2="78.25" x2="30.8229" y1="78.25" x1="28.63365" stroke-linecap="null" stroke-linejoin="null" stroke-dasharray="null" stroke-width="2" fill="none"></line>

        <line stroke="#999" id="svg_22" y2="78.75" x2="48.48291" y1="78.75" x1="46.00175" stroke-linecap="null" stroke-linejoin="null" stroke-dasharray="null" stroke-width="2" fill="none"></line>

        <line stroke="#999" id="svg_23" y2="78" x2="54.17497" y1="78" x1="51.98572" stroke-linecap="null" stroke-linejoin="null" stroke-dasharray="null" stroke-width="2" fill="none"></line>

        <line stroke="#999" id="svg_24" y2="78.75" x2="71.83953" y1="78.75" x1="69.49977" stroke-linecap="null" stroke-linejoin="null" stroke-dasharray="null" stroke-width="2" fill="none"></line>

        <line stroke="#999" id="svg_25" y2="78" x2="77.54522" y1="78" x1="75.19183" stroke-linecap="null" stroke-linejoin="null" stroke-dasharray="null" stroke-width="2" fill="none"></line>

        <line stroke="#999" id="svg_26" y2="78.75" x2="95.33299" y1="78.75" x1="92.99779" stroke-linecap="null" stroke-linejoin="null" stroke-dasharray="null" stroke-width="2" fill="none"></line>

        <rect stroke="#999" id="svg_27" height="23.5" width="43.78513" y="20.25" x="28.34175" stroke-linecap="null" stroke-linejoin="null" stroke-dasharray="null" stroke-width="2" fill="none"></rect>
      </symbol>

      <symbol id="aging">
        <desc>Aging Room Section</desc>

        <rect stroke="#999" style="vector-effect: non-scaling-stroke;" id="svg_2" height="98" width="197.00092" y="2" x="1" stroke-linecap="null" stroke-linejoin="null" stroke-dasharray="null" stroke-width="5" fill="none"></rect>

        <rect stroke="#999" style="vector-effect: non-scaling-stroke;" id="svg_3" height="35.31532" width="23.08839" y="59.38739" x="33.08386" stroke-linecap="null" stroke-linejoin="null" stroke-dasharray="null" stroke-width="5" fill="none"></rect>

        <rect stroke="#999" style="vector-effect: non-scaling-stroke;" id="svg_4" height="35.60961" width="23.68809" y="59.38739" x="144.02806" stroke-linecap="null" stroke-linejoin="null" stroke-dasharray="null" stroke-width="5" fill="none"></rect>

        <rect stroke="#999" style="vector-effect: non-scaling-stroke;" id="svg_5" height="14.12613" width="14.39276" y="60.27027" x="72.06426" stroke-linecap="null" stroke-linejoin="null" stroke-dasharray="null" stroke-width="5" fill="none"></rect>

        <rect stroke="#999" style="vector-effect: non-scaling-stroke;" id="svg_6" height="14.71472" width="14.69261" y="60.27027" x="118.84073" stroke-linecap="null" stroke-linejoin="null" stroke-dasharray="null" stroke-width="5" fill="none"></rect>

        <line stroke="#999" style="vector-effect: non-scaling-stroke;" id="svg_7" y2="12.59459" x2="198.00913" y1="12.59459" x1="1" stroke-linecap="null" stroke-linejoin="null" stroke-dasharray="null" stroke-width="5" fill="none"></line>

        <line stroke="#999" style="vector-effect: non-scaling-stroke;" id="svg_8" y2="11.12312" x2="45.97738" y1="2.29429" x1="45.97738" stroke-linecap="null" stroke-linejoin="null" stroke-dasharray="null" stroke-width="5" fill="none"></line>

        <line stroke="#999" style="vector-effect: non-scaling-stroke;" id="svg_9" y2="12.3176" x2="100.84978" y1="2.29429" x1="100.84978" stroke-linecap="null" stroke-linejoin="null" stroke-dasharray="null" stroke-width="5" fill="none"></line>

        <line stroke="#999" style="vector-effect: non-scaling-stroke;" id="svg_10" y2="12.00601" x2="152.12399" y1="2.29429" x1="152.12399" stroke-linecap="null" stroke-linejoin="null" stroke-dasharray="null" stroke-width="5" fill="none"></line>
      </symbol>

      <symbol id="cooling">
        <desc>Cooling Room Section</desc>

        <rect stroke="#999" id="svg_2" height="97.04191" width="192.33334" y="1.95808" x="3" stroke-linecap="null" stroke-linejoin="null" stroke-dasharray="null" stroke-width="5" fill="none"></rect>

        <rect stroke="#999" id="svg_3" height="14.27944" width="23.04238" y="63.73852" x="63.66259" stroke-linecap="null" stroke-linejoin="null" stroke-dasharray="null" stroke-width="5" fill="none"></rect>

        <rect stroke="#999" id="svg_4" height="34.97006" width="37.62021" y="64.02994" x="101.28281" stroke-linecap="null" stroke-linejoin="null" stroke-dasharray="null" stroke-width="5" fill="none"></rect>

        <line stroke="#999" id="svg_5" y2="12.4491" x2="194.78855" y1="12.4491" x1="3.47025" stroke-linecap="null" stroke-linejoin="null" stroke-dasharray="null" stroke-width="5" fill="none"></line>

        <line stroke="#999" id="svg_6" y2="11.59305" x2="63.19234" y1="2.2495" x1="63.19234" stroke-linecap="null" stroke-linejoin="null" stroke-dasharray="null" stroke-width="5" fill="none"></line>

        <line stroke="#999" id="svg_8" y2="12.46484" x2="124.79544" y1="1.66667" x1="124.79544" stroke-linecap="null" stroke-linejoin="null" stroke-dasharray="null" stroke-width="5" fill="none"></line>
      </symbol>

      <symbol id="aoi">
        <desc>AOI Section</desc>

        <rect stroke="#999" fill="none" stroke-width="3" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x="2.66667" y="2.33333" width="95.33333" height="96.66667" id="svg_2"></rect>

        <rect stroke="#999" fill="none" stroke-width="3" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x="9.90179" y="40.42503" width="31.28125" height="58.57496" id="svg_4"></rect>

        <rect stroke="#999" fill="none" stroke-width="3" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x="60.33482" y="40.42503" width="31.28125" height="57.85626" id="svg_5"></rect>

        <rect stroke="#999" fill="none" stroke-width="3" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x="13.73214" y="46.89343" width="23.40774" height="52.10656" id="svg_6"></rect>

        <rect stroke="#999" fill="none" stroke-width="3" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x="64.16518" y="46.89343" width="23.62054" height="51.74721" id="svg_7"></rect>

        <line stroke="#999" fill="none" stroke-width="3" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x1="13.94494" y1="55.15861" x2="37.16427" y2="55.15861" id="svg_8"></line>

        <line stroke="#999" fill="none" stroke-width="3" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x1="64.59078" y1="55.15861" x2="87.81011" y2="55.15861" id="svg_9"></line>

        <line stroke="#999" fill="none" stroke-width="3" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x1="9.90179" y1="92.17224" x2="13.5256" y2="92.17224" id="svg_10"></line>

        <line stroke="#999" fill="none" stroke-width="3" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x1="37.35268" y1="93.25031" x2="40.76409" y2="93.25031" id="svg_11"></line>

        <line stroke="#999" fill="none" stroke-width="3" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x1="60.33482" y1="93.96901" x2="63.95239" y2="93.96901" id="svg_12"></line>

        <line stroke="#999" fill="none" stroke-width="3" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x1="88.21131" y1="93.25031" x2="91.62272" y2="93.25031" id="svg_13"></line>

        <line stroke="#999" fill="none" stroke-width="3" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x1="41.39583" y1="46.53407" x2="60.12323" y2="46.53407" id="svg_14"></line>

        <line stroke="#999" fill="none" stroke-width="3" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x1="40.97024" y1="40.42503" x2="60.97435" y2="40.42503" id="svg_16"></line>

        <line stroke="#999" fill="none" stroke-width="3" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x1="3.09226" y1="13.114" x2="97.84099" y2="13.114" id="svg_17"></line>

        <line stroke="#999" fill="none" stroke-width="3" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x1="31.39435" y1="3.4114" x2="31.39435" y2="11.67658" id="svg_18"></line>

        <line stroke="#999" fill="none" stroke-width="3" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x1="62.6756" y1="3.05204" x2="62.6756" y2="12.45728" id="svg_19"></line>
      </symbol>

      <symbol id="fi">
        <desc>FI Section</desc>

        <rect fill="none" stroke="#aaa" stroke-width="3" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x="0" y="0" width="180" height="100" id="svg_1"></rect>

        <rect stroke="#999" style="vector-effect: non-scaling-stroke;" fill="none" stroke-width="1" x="3.55556" y="3.11111" width="173.88889" height="94.47382" id="svg_4"></rect>

        <rect stroke="#999" style="vector-effect: non-scaling-stroke;" fill="none" stroke-width="1" x="6.69913" y="40.20512" width="14.89059" height="57.37981" id="svg_5"></rect>

        <rect stroke="#999" style="vector-effect: non-scaling-stroke;" fill="none" stroke-width="1" x="34.23016" y="392.59828" width="0" height="0.57961" id="svg_6"></rect>

        <rect stroke="#999" style="vector-effect: non-scaling-stroke;" fill="none" stroke-width="1" x="8.51909" y="46.58067" width="11.25066" height="50.42468" id="svg_11"></rect>

        <line stroke="#999" style="vector-effect: non-scaling-stroke;" fill="none" x1="8.35364" y1="55.27458" x2="19.78053" y2="55.27458" id="svg_12"></line>

        <line stroke="#999" style="vector-effect: non-scaling-stroke;" fill="none" x1="22.2515" y1="123.66667" x2="22.2515" y2="123.08707" id="svg_13"></line>

        <line stroke="#999" style="vector-effect: non-scaling-stroke;" fill="none" x1="6.69913" y1="90.05021" x2="8.35364" y2="90.05021" id="svg_14"></line>

        <line stroke="#999" style="vector-effect: non-scaling-stroke;" fill="none" x1="19.9352" y1="91.20941" x2="21.43342" y2="91.20941" id="svg_16"></line>

        <rect stroke="#999" style="vector-effect: non-scaling-stroke;" fill="none" stroke-width="1" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x="23.74057" y="40.20512" width="14.72513" height="57.37981" id="svg_18"></rect>

        <rect stroke="#999" style="vector-effect: non-scaling-stroke;" fill="none" stroke-width="1" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x="25.56052" y="46.58067" width="11.08521" height="51.00428" id="svg_19"></rect>

        <rect stroke="#999" style="vector-effect: non-scaling-stroke;" fill="none" stroke-width="1" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x="40.78201" y="40.20512" width="14.55968" height="56.80021" id="svg_22"></rect>

        <rect stroke="#999" style="vector-effect: non-scaling-stroke;" fill="none" stroke-width="1" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x="57.658" y="40.20512" width="14.55968" height="57.95941" id="svg_23"></rect>

        <rect stroke="#999" style="vector-effect: non-scaling-stroke;" fill="none" stroke-width="1" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x="74.69945" y="40.20512" width="14.72513" height="57.37981" id="svg_24"></rect>

        <rect stroke="#999" style="vector-effect: non-scaling-stroke;" fill="none" stroke-width="1" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x="91.57544" y="40.78472" width="14.89059" height="56.80021" id="svg_25"></rect>

        <rect stroke="#999" style="vector-effect: non-scaling-stroke;" fill="none" stroke-width="1" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x="108.61687" y="40.20512" width="14.55968" height="57.37981" id="svg_26"></rect>

        <rect stroke="#999" style="vector-effect: non-scaling-stroke;" fill="none" stroke-width="1" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x="125.49287" y="40.20512" width="14.72513" height="56.80021" id="svg_27"></rect>

        <rect stroke="#999" style="vector-effect: non-scaling-stroke;" fill="none" stroke-width="1" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x="142.69977" y="40.20512" width="14.55968" height="57.95941" id="svg_28"></rect>

        <rect stroke="#999" style="vector-effect: non-scaling-stroke;" fill="none" stroke-width="1" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x="159.24486" y="40.20512" width="14.72513" height="57.37981" id="svg_29"></rect>

        <rect stroke="#999" style="vector-effect: non-scaling-stroke;" fill="none" stroke-width="1" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x="42.43651" y="47.16025" width="11.25066" height="49.84509" id="svg_30"></rect>

        <rect stroke="#999" style="vector-effect: non-scaling-stroke;" fill="none" stroke-width="1" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x="59.64342" y="47.16025" width="10.91976" height="50.42468" id="svg_31"></rect>

        <rect stroke="#999" style="vector-effect: non-scaling-stroke;" fill="none" stroke-width="1" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x="76.51941" y="47.16025" width="11.08521" height="49.84509" id="svg_32"></rect>

        <rect stroke="#999" style="vector-effect: non-scaling-stroke;" fill="none" stroke-width="1" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x="93.3954" y="46.58067" width="10.91976" height="51.00428" id="svg_33"></rect>

        <rect stroke="#999" style="vector-effect: non-scaling-stroke;" fill="none" stroke-width="1" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x="110.27139" y="46.26756" width="11.25066" height="51.00428" id="svg_34"></rect>

        <rect stroke="#999" style="vector-effect: non-scaling-stroke;" fill="none" stroke-width="1" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x="127.31283" y="46.42381" width="11.08521" height="51.00428" id="svg_35"></rect>

        <rect stroke="#999" style="vector-effect: non-scaling-stroke;" fill="none" stroke-width="1" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x="144.51972" y="46.58067" width="10.91976" height="51.00428" id="svg_36"></rect>

        <rect stroke="#999" style="vector-effect: non-scaling-stroke;" fill="none" stroke-width="1" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x="161.23027" y="46.58067" width="10.91976" height="51.00428" id="svg_37"></rect>

        <line stroke="#999" style="vector-effect: non-scaling-stroke;" fill="none" stroke-width="1" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x1="25.72597" y1="55.27458" x2="36.48156" y2="55.27458" id="svg_39"></line>

        <line stroke="#999" style="vector-effect: non-scaling-stroke;" fill="none" stroke-width="1" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x1="42.43651" y1="54.69499" x2="53.69205" y2="54.69499" id="svg_40"></line>

        <line stroke="#999" style="vector-effect: non-scaling-stroke;" fill="none" stroke-width="1" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x1="59.64342" y1="54.69499" x2="70.36076" y2="54.69499" id="svg_41"></line>

        <line stroke="#999" style="vector-effect: non-scaling-stroke;" fill="none" stroke-width="1" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x1="76.51941" y1="54.69499" x2="87.4592" y2="54.69499" id="svg_43"></line>

        <line stroke="#999" style="vector-effect: non-scaling-stroke;" fill="none" stroke-width="1" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x1="93.3954" y1="55.27458" x2="104.65701" y2="55.27458" id="svg_44"></line>

        <line stroke="#999" style="vector-effect: non-scaling-stroke;" fill="none" stroke-width="1" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x1="110.27139" y1="54.69499" x2="121.47939" y2="54.69499" id="svg_46"></line>

        <line stroke="#999" style="vector-effect: non-scaling-stroke;" fill="none" stroke-width="1" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x1="127.31283" y1="54.69499" x2="138.51717" y2="54.69499" id="svg_47"></line>

        <line stroke="#999" style="vector-effect: non-scaling-stroke;" fill="none" stroke-width="1" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x1="144.51972" y1="54.69499" x2="155.33621" y2="54.69499" id="svg_50"></line>

        <line stroke="#999" style="vector-effect: non-scaling-stroke;" fill="none" stroke-width="1" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x1="161.23027" y1="54.69499" x2="171.99602" y2="54.69499" id="svg_52"></line>

        <line stroke="#999" style="vector-effect: non-scaling-stroke;" fill="none" stroke-width="1" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x1="23.90602" y1="90.05021" x2="25.40424" y2="90.05021" id="svg_53"></line>

        <line stroke="#999" style="vector-effect: non-scaling-stroke;" fill="none" stroke-width="1" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x1="36.64574" y1="91.20941" x2="38.14396" y2="91.20941" id="svg_54"></line>

        <line stroke="#999" style="vector-effect: non-scaling-stroke;" fill="none" stroke-width="1" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x1="40.94747" y1="90.62981" x2="42.27107" y2="90.62981" id="svg_55"></line>

        <line stroke="#999" style="vector-effect: non-scaling-stroke;" fill="none" stroke-width="1" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x1="53.85263" y1="91.78899" x2="55.18654" y2="91.78899" id="svg_57"></line>

        <line stroke="#999" style="vector-effect: non-scaling-stroke;" fill="none" stroke-width="1" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x1="57.82346" y1="90.05021" x2="59.31251" y2="90.05021" id="svg_58"></line>

        <line stroke="#999" style="vector-effect: non-scaling-stroke;" fill="none" stroke-width="1" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x1="70.39772" y1="91.20941" x2="72.05224" y2="91.20941" id="svg_59"></line>

        <line stroke="#999" style="vector-effect: non-scaling-stroke;" fill="none" stroke-width="1" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x1="74.69945" y1="90.05021" x2="76.35396" y2="90.05021" id="svg_60"></line>

        <line stroke="#999" style="vector-effect: non-scaling-stroke;" fill="none" stroke-width="1" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x1="87.60461" y1="91.78899" x2="89.13" y2="91.78899" id="svg_61"></line>

        <line stroke="#999" style="vector-effect: non-scaling-stroke;" fill="none" stroke-width="1" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x1="91.74088" y1="90.05021" x2="93.40365" y2="90.05021" id="svg_62"></line>

        <line stroke="#999" style="vector-effect: non-scaling-stroke;" fill="none" stroke-width="1" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x1="104.31515" y1="91.20941" x2="106.16495" y2="91.20941" id="svg_63"></line>

        <line stroke="#999" style="vector-effect: non-scaling-stroke;" fill="none" stroke-width="1" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x1="108.61687" y1="90.62981" x2="110.10594" y2="90.62981" id="svg_64"></line>

        <line stroke="#999" style="vector-effect: non-scaling-stroke;" fill="none" stroke-width="1" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x1="121.3566" y1="91.20941" x2="123.04388" y2="91.20941" id="svg_65"></line>

        <line stroke="#999" style="vector-effect: non-scaling-stroke;" fill="none" stroke-width="1" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x1="125.49287" y1="90.62981" x2="127.32033" y2="90.62981" id="svg_66"></line>

        <line stroke="#999" style="vector-effect: non-scaling-stroke;" fill="none" stroke-width="1" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x1="138.39805" y1="91.20941" x2="140.05255" y2="91.20941" id="svg_67"></line>

        <line stroke="#999" style="vector-effect: non-scaling-stroke;" fill="none" stroke-width="1" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x1="142.69977" y1="90.05021" x2="144.18883" y2="90.05021" id="svg_68"></line>

        <line stroke="#999" style="vector-effect: non-scaling-stroke;" fill="none" stroke-width="1" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x1="155.27404" y1="91.78899" x2="157.09399" y2="91.78899" id="svg_70"></line>

        <line stroke="#999" style="vector-effect: non-scaling-stroke;" fill="none" stroke-width="1" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x1="159.24486" y1="90.62981" x2="161.07232" y2="90.62981" id="svg_71"></line>

        <line stroke="#999" style="vector-effect: non-scaling-stroke;" fill="none" stroke-width="1" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x1="172.15003" y1="91.78899" x2="173.96999" y2="91.78899" id="svg_72"></line>
      </symbol>

      <symbol id="pullTape">
        <title>PULL TAPE</title>

        <rect fill="none" stroke="#aaa" stroke-width="5" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x="0" y="0" width="165" height="85" id="svg_1"></rect>

        <rect fill="none" stroke="#aaa" stroke-width="4" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x="0" y="25" width="35" height="38" id="svg_2"></rect>

        <rect fill="none" stroke="#aaa" stroke-width="4" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x="130" y="25" width="35" height="38" id="svg_3"></rect>

        <line fill="none" stroke="#aaa" stroke-width="4" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x1="35" y1="30" x2="130" y2="30" id="svg_4"></line>

        <line fill="none" stroke="#aaa" stroke-width="4" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x1="35" y1="55" x2="130" y2="55" id="svg_4"></line>
      </symbol>

      <symbol id="appAoi">
        <title>APP AOI</title>

        <rect fill="none" stroke="#aaa" stroke-width="4" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x="4.666667" y="15.333333" width="149.333333" height="89.666667" id="svg_2"></rect>

        <rect fill="none" stroke="#aaa" stroke-width="4" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x="16" y="50.666667" width="49" height="54.333333" id="svg_4"></rect>

        <rect fill="none" stroke="#aaa" stroke-width="4" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x="95" y="50.666667" width="49" height="53.666667" id="svg_5"></rect>

        <rect fill="none" stroke="#aaa" stroke-width="4" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x="22" y="56.666667" width="36.666667" height="48.333333" id="svg_6"></rect>

        <rect fill="none" stroke="#aaa" stroke-width="4" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x="101" y="56.666667" width="37" height="48" id="svg_7"></rect>

        <line fill="none" stroke="#aaa" stroke-width="4" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x1="22.333333" y1="64.333333" x2="58.704873" y2="64.333333" id="svg_8"></line>

        <line fill="none" stroke="#aaa" stroke-width="4" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x1="101.666667" y1="64.333333" x2="138.038206" y2="64.333333" id="svg_9"></line>

        <line fill="none" stroke="#aaa" stroke-width="4" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x1="16" y1="98.666667" x2="21.676462" y2="98.666667" id="svg_10"></line>

        <line fill="none" stroke="#aaa" stroke-width="4" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x1="59" y1="99.666667" x2="64.34374" y2="99.666667" id="svg_11"></line>

        <line fill="none" stroke="#aaa" stroke-width="4" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x1="95" y1="100.333333" x2="100.666667" y2="100.333333" id="svg_12"></line>

        <line fill="none" stroke="#aaa" stroke-width="4" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x1="138.666667" y1="99.666667" x2="144.010407" y2="99.666667" id="svg_13"></line>

        <line fill="none" stroke="#aaa" stroke-width="4" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x1="65.333333" y1="56.333333" x2="94.668561" y2="56.333333" id="svg_14"></line>

        <line fill="none" stroke="#aaa" stroke-width="4" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x1="64.666667" y1="50.666667" x2="96.001773" y2="50.666667" id="svg_16"></line>

        <line fill="none" stroke="#aaa" stroke-width="4" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x1="5.333333" y1="25.333333" x2="153.750912" y2="25.333333" id="svg_17"></line>

        <line fill="none" stroke="#aaa" stroke-width="4" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x1="49.666667" y1="16.333333" x2="49.666667" y2="24" id="svg_18"></line>

        <line fill="none" stroke="#aaa" stroke-width="4" stroke-dasharray="null" stroke-linejoin="null" stroke-linecap="null" x1="98.666667" y1="16" x2="98.666667" y2="24.724168" id="svg_19"></line>
      </symbol>
    </svg>
  </div>

  <div class="logo">
    <h1>
      B
      <span style="margin-left: -10px;margin-right: -10px;">O</span>
      E
    </h1>

    <div style="border: 2.5px solid black; width: 20px;height: 2.5px;margin-left: 29px;margin-top: -13px;"></div>
  </div>

  <div class="title">
    <h1 style="margin-top: 5px">
      AT设备信息化管理系统
      <span style="font-size: 25px;">—B8 MDL技术一部</span>
    </h1>
  </div>

  <div class="container">
    <div class="header" id="header">
      <span style="position: relative; width: 50px; height: 30px; margin-right: 30px;" id="id-btn-dialog-alarm">
        <a href="#" data-toggle="modal" data-target="#myModal">
          <img src="assets/img/bell.svg" style="width: 20px; height: 20px;" />
          <span class="badge badge-danger" style="position: absolute; top: -10px; right: -20px" v-text="alarmNumTotal"></span>
        </a>
      </span>

      <span style="position: relative; width: 50px; height: 30px; margin-right: 30px;">
        <a href="line.html">
          <img src="assets/img/fork.svg" style="width: 20px; height: 20px;" />
          <span class="badge badge-primary" style="position: absolute; top: -10px; right: -20px"></span>
        </a>
      </span>

      <span onclick="handleFullScreen()" style="position: relative; width: 50px; height: 30px; margin-right: 30px;">
        <img src="assets/img/grid-three-up.svg" style="width: 20px; height: 20px;" />
        <span class="badge badge-info" style="position: absolute; top: -10px; right: -20px"></span>
      </span>

      <!-- <span style="position: relative; width: 50px; height: 30px; margin-right: 30px;"> -->

      <!-- <img src="assets/img/warning.svg" style="width: 20px; height: 20px;"></img> -->

      <!-- <span class="badge badge-warning" style="position: absolute; top: -10px; right: -20px"></span> -->

      <!-- </span> -->
    </div>
  </div>

  <div class="root" id="scram">
    <div class="level1">
      <div class="floor" style="opacity: 1;">
        <div class="div000 trans">
          <div class="div01" id="line8eq1" v-bind:style="{backgroundColor: color}"></div>

          <div class="div02"></div>

          <div class="div03">
            <span id="tooltip8" href="#" data-toggle="popover" data-placement="top" data-html="true" data-template="&lt;div class=&#39;popover&#39; role=&#39;tooltip&#39; style=&#39;border-radius:10px&#39;&gt;&lt;div class=&#39;arrow&#39;&gt;&lt;/div&gt;&lt;h3 class=&#39;popover-header&#39;&gt;&lt;/h3&gt;&lt;div class=&#39;popover-body&#39; style=&#39;background-color:red;color:white;border-radius:10px&#39;&gt;&lt;/div&gt;&lt;/div&gt;" v-bind:data-content="alarmNum">
              <a href="line.html" v-text="id" v-on:click="goLine"></a>
            </span>
          </div>

          <div class="div04"></div>

          <div class="div11" id="line8eq2" v-bind:style="{backgroundColor: color}"></div>

          <div class="div12"></div>

          <div class="div13"></div>

          <div class="div14"></div>

          <div class="div21" id="line8eq3" v-bind:style="{backgroundColor: color}"></div>

          <div class="div22"></div>

          <div class="div23"></div>

          <div class="div24"></div>

          <div class="div31" id="line8eq4" v-bind:style="{backgroundColor: color}"></div>

          <div class="div32"></div>

          <div class="div33"></div>

          <div class="div34"></div>

          <div class="div41" id="line8eq5" v-bind:style="{backgroundColor: color}"></div>

          <div class="div42"></div>

          <div class="div43"></div>

          <div class="div44"></div>

          <div class="div51" id="line8eq6" v-bind:style="{backgroundColor: color}"></div>

          <div class="div52"></div>

          <div class="div53"></div>

          <div class="div54"></div>

          <div class="div61" id="line8eq7" v-bind:style="{backgroundColor: color}"></div>

          <div class="div62"></div>

          <div class="div63"></div>

          <div class="div64"></div>

          <div class="div71" id="line8eq8" v-bind:style="{backgroundColor: color}"></div>

          <div class="div72"></div>

          <div class="div73"></div>

          <div class="div74"></div>

          <div class="div81" id="line8eq9" v-bind:style="{backgroundColor: color}"></div>

          <div class="div82"></div>

          <div class="div83"></div>

          <div class="div84"></div>

          <div class="div91" id="line8eq10" v-bind:style="{backgroundColor: color}"></div>

          <div class="div92"></div>

          <div class="div93"></div>

          <div class="div94"></div>

          <svg class="embed01">
            <use xlink:href="#ohc"></use>
          </svg>

          <svg class="embed02">
            <use xlink:href="#assy"></use>
          </svg>

          <svg class="embed03">
            <use xlink:href="#autoTape"></use>
          </svg>

          <svg class="embed04">
            <use xlink:href="#assyTest"></use>
          </svg>

          <svg class="embed05">
            <use xlink:href="#aging"></use>
          </svg>

          <svg class="embed06">
            <use xlink:href="#cooling"></use>
          </svg>

          <svg class="embed07">
            <use xlink:href="#aoi"></use>
          </svg>

          <svg class="embed08">
            <use xlink:href="#fi"></use>
          </svg>

          <svg class="embed09">
            <use xlink:href="#pullTape"></use>
          </svg>

          <svg class="embed10">
            <use xlink:href="#appAoi"></use>
          </svg>
          <div class="divLineId">8</div>
        </div>

        <div class="div001 trans">
          <div class="div01" id="line9eq1" v-bind:style="{backgroundColor: color}"></div>

          <div class="div02"></div>

          <div class="div03">
            <span id="tooltip9" href="#" data-toggle="popover" data-placement="top" data-html="true" data-template="&lt;div class=&#39;popover&#39; role=&#39;tooltip&#39; style=&#39;border-radius:10px&#39;&gt;&lt;div class=&#39;arrow&#39;&gt;&lt;/div&gt;&lt;h3 class=&#39;popover-header&#39;&gt;&lt;/h3&gt;&lt;div class=&#39;popover-body&#39; style=&#39;background-color:red;color:white;border-radius:10px&#39;&gt;&lt;/div&gt;&lt;/div&gt;" v-bind:data-content="alarmNum">
              <a href="line.html" v-text="id" v-on:click="goLine"></a>
            </span>
          </div>

          <div class="div04"></div>

          <div class="div11" id="line9eq2" v-bind:style="{backgroundColor: color}"></div>

          <div class="div12"></div>

          <div class="div13"></div>

          <div class="div14"></div>

          <div class="div21" id="line9eq3" v-bind:style="{backgroundColor: color}"></div>

          <div class="div22"></div>

          <div class="div23"></div>

          <div class="div24"></div>

          <div class="div31" id="line9eq4" v-bind:style="{backgroundColor: color}"></div>

          <div class="div32"></div>

          <div class="div33"></div>

          <div class="div34"></div>

          <div class="div41" id="line9eq5" v-bind:style="{backgroundColor: color}"></div>

          <div class="div42"></div>

          <div class="div43"></div>

          <div class="div44"></div>

          <div class="div51" id="line9eq6" v-bind:style="{backgroundColor: color}"></div>

          <div class="div52"></div>

          <div class="div53"></div>

          <div class="div54"></div>

          <div class="div61" id="line9eq7" v-bind:style="{backgroundColor: color}"></div>

          <div class="div62"></div>

          <div class="div63"></div>

          <div class="div64"></div>

          <div class="div71" id="line9eq8" v-bind:style="{backgroundColor: color}"></div>

          <div class="div72"></div>

          <div class="div73"></div>

          <div class="div74"></div>

          <div class="div81" id="line9eq9" v-bind:style="{backgroundColor: color}"></div>

          <div class="div82"></div>

          <div class="div83"></div>

          <div class="div84"></div>

          <div class="div91" id="line9eq10" v-bind:style="{backgroundColor: color}"></div>

          <div class="div92"></div>

          <div class="div93"></div>

          <div class="div94"></div>

          <svg class="embed01">
            <use xlink:href="#ohc"></use>
          </svg>

          <svg class="embed02">
            <use xlink:href="#assy"></use>
          </svg>

          <svg class="embed03">
            <use xlink:href="#autoTape"></use>
          </svg>

          <svg class="embed04">
            <use xlink:href="#assyTest"></use>
          </svg>

          <svg class="embed05">
            <use xlink:href="#aging"></use>
          </svg>

          <svg class="embed06">
            <use xlink:href="#cooling"></use>
          </svg>

          <svg class="embed07">
            <use xlink:href="#aoi"></use>
          </svg>

          <svg class="embed08">
            <use xlink:href="#fi"></use>
          </svg>

          <svg class="embed09">
            <use xlink:href="#pullTape"></use>
          </svg>

          <svg class="embed10">
            <use xlink:href="#appAoi"></use>
          </svg>
          <div class="divLineId">9</div>
        </div>

        <div class="div002 trans">
          <div class="div01" id="line10eq1" v-bind:style="{backgroundColor: color}"></div>

          <div class="div02"></div>

          <div class="div03">
            <span id="tooltip10" href="#" data-toggle="popover" data-placement="top" data-html="true" data-template="&lt;div class=&#39;popover&#39; role=&#39;tooltip&#39; style=&#39;border-radius:10px&#39;&gt;&lt;div class=&#39;arrow&#39;&gt;&lt;/div&gt;&lt;h3 class=&#39;popover-header&#39;&gt;&lt;/h3&gt;&lt;div class=&#39;popover-body&#39; style=&#39;background-color:red;color:white;border-radius:10px&#39;&gt;&lt;/div&gt;&lt;/div&gt;" v-bind:data-content="alarmNum">
              <a href="line.html" v-text="id" v-on:click="goLine"></a>
            </span>
          </div>

          <div class="div04"></div>

          <div class="div11" id="line10eq2" v-bind:style="{backgroundColor: color}"></div>

          <div class="div12"></div>

          <div class="div13"></div>

          <div class="div14"></div>

          <div class="div21" id="line10eq3" v-bind:style="{backgroundColor: color}"></div>

          <div class="div22"></div>

          <div class="div23"></div>

          <div class="div24"></div>

          <div class="div31" id="line10eq4" v-bind:style="{backgroundColor: color}"></div>

          <div class="div32"></div>

          <div class="div33"></div>

          <div class="div34"></div>

          <div class="div41" id="line10eq5" v-bind:style="{backgroundColor: color}"></div>

          <div class="div42"></div>

          <div class="div43"></div>

          <div class="div44"></div>

          <div class="div51" id="line10eq6" v-bind:style="{backgroundColor: color}"></div>

          <div class="div52"></div>

          <div class="div53"></div>

          <div class="div54"></div>

          <div class="div61" id="line10eq7" v-bind:style="{backgroundColor: color}"></div>

          <div class="div62"></div>

          <div class="div63"></div>

          <div class="div64"></div>

          <div class="div71" id="line10eq8" v-bind:style="{backgroundColor: color}"></div>

          <div class="div72"></div>

          <div class="div73"></div>

          <div class="div74"></div>

          <div class="div81" id="line10eq9" v-bind:style="{backgroundColor: color}"></div>

          <div class="div82"></div>

          <div class="div83"></div>

          <div class="div84"></div>

          <div class="div91" id="line10eq10" v-bind:style="{backgroundColor: color}"></div>

          <div class="div92"></div>

          <div class="div93"></div>

          <div class="div94"></div>

          <svg class="embed01">
            <use xlink:href="#ohc"></use>
          </svg>

          <svg class="embed02">
            <use xlink:href="#assy"></use>
          </svg>

          <svg class="embed03">
            <use xlink:href="#autoTape"></use>
          </svg>

          <svg class="embed04">
            <use xlink:href="#assyTest"></use>
          </svg>

          <svg class="embed05">
            <use xlink:href="#aging"></use>
          </svg>

          <svg class="embed06">
            <use xlink:href="#cooling"></use>
          </svg>

          <svg class="embed07">
            <use xlink:href="#aoi"></use>
          </svg>

          <svg class="embed08">
            <use xlink:href="#fi"></use>
          </svg>

          <svg class="embed09">
            <use xlink:href="#pullTape"></use>
          </svg>

          <svg class="embed10">
            <use xlink:href="#appAoi"></use>
          </svg>
          <div class="divLineId">10</div>
        </div>

        <div class="div003 trans">
          <div class="div01" id="line11eq1" v-bind:style="{backgroundColor: color}"></div>

          <div class="div02"></div>

          <div class="div03">
            <span id="tooltip11" href="#" data-toggle="popover" data-placement="top" data-html="true" data-template="&lt;div class=&#39;popover&#39; role=&#39;tooltip&#39; style=&#39;border-radius:10px&#39;&gt;&lt;div class=&#39;arrow&#39;&gt;&lt;/div&gt;&lt;h3 class=&#39;popover-header&#39;&gt;&lt;/h3&gt;&lt;div class=&#39;popover-body&#39; style=&#39;background-color:red;color:white;border-radius:10px&#39;&gt;&lt;/div&gt;&lt;/div&gt;" v-bind:data-content="alarmNum">
              <a href="line.html" v-text="id" v-on:click="goLine"></a>
            </span>
          </div>

          <div class="div04"></div>

          <div class="div11" id="line11eq2" v-bind:style="{backgroundColor: color}"></div>

          <div class="div12"></div>

          <div class="div13"></div>

          <div class="div14"></div>

          <div class="div21" id="line11eq3" v-bind:style="{backgroundColor: color}"></div>

          <div class="div22"></div>

          <div class="div23"></div>

          <div class="div24"></div>

          <div class="div31" id="line11eq4" v-bind:style="{backgroundColor: color}"></div>

          <div class="div32"></div>

          <div class="div33"></div>

          <div class="div34"></div>

          <div class="div41" id="line11eq5" v-bind:style="{backgroundColor: color}"></div>

          <div class="div42"></div>

          <div class="div43"></div>

          <div class="div44"></div>

          <div class="div51" id="line11eq6" v-bind:style="{backgroundColor: color}"></div>

          <div class="div52"></div>

          <div class="div53"></div>

          <div class="div54"></div>

          <div class="div61" id="line11eq7" v-bind:style="{backgroundColor: color}"></div>

          <div class="div62"></div>

          <div class="div63"></div>

          <div class="div64"></div>

          <div class="div71" id="line11eq8" v-bind:style="{backgroundColor: color}"></div>

          <div class="div72"></div>

          <div class="div73"></div>

          <div class="div74"></div>

          <div class="div81" id="line11eq9" v-bind:style="{backgroundColor: color}"></div>

          <div class="div82"></div>

          <div class="div83"></div>

          <div class="div84"></div>

          <div class="div91" id="line11eq10" v-bind:style="{backgroundColor: color}"></div>

          <div class="div92"></div>

          <div class="div93"></div>

          <div class="div94"></div>

          <svg class="embed01">
            <use xlink:href="#ohc"></use>
          </svg>

          <svg class="embed02">
            <use xlink:href="#assy"></use>
          </svg>

          <svg class="embed03">
            <use xlink:href="#autoTape"></use>
          </svg>

          <svg class="embed04">
            <use xlink:href="#assyTest"></use>
          </svg>

          <svg class="embed05">
            <use xlink:href="#aging"></use>
          </svg>

          <svg class="embed06">
            <use xlink:href="#cooling"></use>
          </svg>

          <svg class="embed07">
            <use xlink:href="#aoi"></use>
          </svg>

          <svg class="embed08">
            <use xlink:href="#fi"></use>
          </svg>

          <svg class="embed09">
            <use xlink:href="#pullTape"></use>
          </svg>

          <svg class="embed10">
            <use xlink:href="#appAoi"></use>
          </svg>
          <div class="divLineId">11</div>
        </div>

        <div class="div004 trans">
          <div class="div01" id="line12eq1" v-bind:style="{backgroundColor: color}"></div>

          <div class="div02"></div>

          <div class="div03">
            <span id="tooltip12" href="#" data-toggle="popover" data-placement="top" data-html="true" data-template="&lt;div class=&#39;popover&#39; role=&#39;tooltip&#39; style=&#39;border-radius:10px&#39;&gt;&lt;div class=&#39;arrow&#39;&gt;&lt;/div&gt;&lt;h3 class=&#39;popover-header&#39;&gt;&lt;/h3&gt;&lt;div class=&#39;popover-body&#39; style=&#39;background-color:red;color:white;border-radius:10px&#39;&gt;&lt;/div&gt;&lt;/div&gt;" v-bind:data-content="alarmNum">
              <a href="line.html" v-text="id" v-on:click="goLine"></a>
            </span>
          </div>

          <div class="div04"></div>

          <div class="div11" id="line12eq2" v-bind:style="{backgroundColor: color}"></div>

          <div class="div12"></div>

          <div class="div13"></div>

          <div class="div14"></div>

          <div class="div21" id="line12eq3" v-bind:style="{backgroundColor: color}"></div>

          <div class="div22"></div>

          <div class="div23"></div>

          <div class="div24"></div>

          <div class="div31" id="line12eq4" v-bind:style="{backgroundColor: color}"></div>

          <div class="div32"></div>

          <div class="div33"></div>

          <div class="div34"></div>

          <div class="div41" id="line12eq5" v-bind:style="{backgroundColor: color}"></div>

          <div class="div42"></div>

          <div class="div43"></div>

          <div class="div44"></div>

          <div class="div51" id="line12eq6" v-bind:style="{backgroundColor: color}"></div>

          <div class="div52"></div>

          <div class="div53"></div>

          <div class="div54"></div>

          <div class="div61" id="line12eq7" v-bind:style="{backgroundColor: color}"></div>

          <div class="div62"></div>

          <div class="div63"></div>

          <div class="div64"></div>

          <div class="div71" id="line12eq8" v-bind:style="{backgroundColor: color}"></div>

          <div class="div72"></div>

          <div class="div73"></div>

          <div class="div74"></div>

          <div class="div81" id="line12eq9" v-bind:style="{backgroundColor: color}"></div>

          <div class="div82"></div>

          <div class="div83"></div>

          <div class="div84"></div>

          <div class="div91" id="line12eq10" v-bind:style="{backgroundColor: color}"></div>

          <div class="div92"></div>

          <div class="div93"></div>

          <div class="div94"></div>

          <svg class="embed01">
            <use xlink:href="#ohc"></use>
          </svg>

          <svg class="embed02">
            <use xlink:href="#assy"></use>
          </svg>

          <svg class="embed03">
            <use xlink:href="#autoTape"></use>
          </svg>

          <svg class="embed04">
            <use xlink:href="#assyTest"></use>
          </svg>

          <svg class="embed05">
            <use xlink:href="#aging"></use>
          </svg>

          <svg class="embed06">
            <use xlink:href="#cooling"></use>
          </svg>

          <svg class="embed07">
            <use xlink:href="#aoi"></use>
          </svg>

          <svg class="embed08">
            <use xlink:href="#fi"></use>
          </svg>

          <svg class="embed09">
            <use xlink:href="#pullTape"></use>
          </svg>

          <svg class="embed10">
            <use xlink:href="#appAoi"></use>
          </svg>
          <div class="divLineId">12</div>
        </div>

        <div class="div005 trans">
          <div class="div01" id="line13eq1" v-bind:style="{backgroundColor: color}"></div>

          <div class="div02"></div>

          <div class="div03">
            <span id="tooltip13" href="#" data-toggle="popover" data-placement="top" data-html="true" data-template="&lt;div class=&#39;popover&#39; role=&#39;tooltip&#39; style=&#39;border-radius:10px&#39;&gt;&lt;div class=&#39;arrow&#39;&gt;&lt;/div&gt;&lt;h3 class=&#39;popover-header&#39;&gt;&lt;/h3&gt;&lt;div class=&#39;popover-body&#39; style=&#39;background-color:red;color:white;border-radius:10px&#39;&gt;&lt;/div&gt;&lt;/div&gt;" v-bind:data-content="alarmNum">
              <a href="line.html" v-text="id" v-on:click="goLine"></a>
            </span>
          </div>

          <div class="div04"></div>

          <div class="div11" id="line13eq2" v-bind:style="{backgroundColor: color}"></div>

          <div class="div12"></div>

          <div class="div13"></div>

          <div class="div14"></div>

          <div class="div21" id="line13eq3" v-bind:style="{backgroundColor: color}"></div>

          <div class="div22"></div>

          <div class="div23"></div>

          <div class="div24"></div>

          <div class="div31" id="line13eq4" v-bind:style="{backgroundColor: color}"></div>

          <div class="div32"></div>

          <div class="div33"></div>

          <div class="div34"></div>

          <div class="div41" id="line13eq5" v-bind:style="{backgroundColor: color}"></div>

          <div class="div42"></div>

          <div class="div43"></div>

          <div class="div44"></div>

          <div class="div51" id="line13eq6" v-bind:style="{backgroundColor: color}"></div>

          <div class="div52"></div>

          <div class="div53"></div>

          <div class="div54"></div>

          <div class="div61" id="line13eq7" v-bind:style="{backgroundColor: color}"></div>

          <div class="div62"></div>

          <div class="div63"></div>

          <div class="div64"></div>

          <div class="div71" id="line13eq8" v-bind:style="{backgroundColor: color}"></div>

          <div class="div72"></div>

          <div class="div73"></div>

          <div class="div74"></div>

          <div class="div81" id="line13eq9" v-bind:style="{backgroundColor: color}"></div>

          <div class="div82"></div>

          <div class="div83"></div>

          <div class="div84"></div>

          <div class="div91" id="line13eq10" v-bind:style="{backgroundColor: color}"></div>

          <div class="div92"></div>

          <div class="div93"></div>

          <div class="div94"></div>

          <svg class="embed01">
            <use xlink:href="#ohc"></use>
          </svg>

          <svg class="embed02">
            <use xlink:href="#assy"></use>
          </svg>

          <svg class="embed03">
            <use xlink:href="#autoTape"></use>
          </svg>

          <svg class="embed04">
            <use xlink:href="#assyTest"></use>
          </svg>

          <svg class="embed05">
            <use xlink:href="#aging"></use>
          </svg>

          <svg class="embed06">
            <use xlink:href="#cooling"></use>
          </svg>

          <svg class="embed07">
            <use xlink:href="#aoi"></use>
          </svg>

          <svg class="embed08">
            <use xlink:href="#fi"></use>
          </svg>

          <svg class="embed09">
            <use xlink:href="#pullTape"></use>
          </svg>

          <svg class="embed10">
            <use xlink:href="#appAoi"></use>
          </svg>
          <div class="divLineId">13</div>
        </div>

        <div class="div006 trans">
          <div class="div01" id="line14eq1" v-bind:style="{backgroundColor: color}"></div>

          <div class="div02"></div>

          <div class="div03">
            <span id="tooltip14" href="#" data-toggle="popover" data-placement="top" data-html="true" data-template="&lt;div class=&#39;popover&#39; role=&#39;tooltip&#39; style=&#39;border-radius:10px&#39;&gt;&lt;div class=&#39;arrow&#39;&gt;&lt;/div&gt;&lt;h3 class=&#39;popover-header&#39;&gt;&lt;/h3&gt;&lt;div class=&#39;popover-body&#39; style=&#39;background-color:red;color:white;border-radius:10px&#39;&gt;&lt;/div&gt;&lt;/div&gt;" v-bind:data-content="alarmNum">
              <a href="line.html" v-text="id" v-on:click="goLine"></a>
            </span>
          </div>

          <div class="div04"></div>

          <div class="div11" id="line14eq2" v-bind:style="{backgroundColor: color}"></div>

          <div class="div12"></div>

          <div class="div13"></div>

          <div class="div14"></div>

          <div class="div21" id="line14eq3" v-bind:style="{backgroundColor: color}"></div>

          <div class="div22"></div>

          <div class="div23"></div>

          <div class="div24"></div>

          <div class="div31" id="line14eq4" v-bind:style="{backgroundColor: color}"></div>

          <div class="div32"></div>

          <div class="div33"></div>

          <div class="div34"></div>

          <div class="div41" id="line14eq5" v-bind:style="{backgroundColor: color}"></div>

          <div class="div42"></div>

          <div class="div43"></div>

          <div class="div44"></div>

          <div class="div51" id="line14eq6" v-bind:style="{backgroundColor: color}"></div>

          <div class="div52"></div>

          <div class="div53"></div>

          <div class="div54"></div>

          <div class="div61" id="line14eq7" v-bind:style="{backgroundColor: color}"></div>

          <div class="div62"></div>

          <div class="div63"></div>

          <div class="div64"></div>

          <div class="div71" id="line14eq8" v-bind:style="{backgroundColor: color}"></div>

          <div class="div72"></div>

          <div class="div73"></div>

          <div class="div74"></div>

          <div class="div81" id="line14eq9" v-bind:style="{backgroundColor: color}"></div>

          <div class="div82"></div>

          <div class="div83"></div>

          <div class="div84"></div>

          <div class="div91" id="line14eq10" v-bind:style="{backgroundColor: color}"></div>

          <div class="div92"></div>

          <div class="div93"></div>

          <div class="div94"></div>

          <svg class="embed01">
            <use xlink:href="#ohc"></use>
          </svg>

          <svg class="embed02">
            <use xlink:href="#assy"></use>
          </svg>

          <svg class="embed03">
            <use xlink:href="#autoTape"></use>
          </svg>

          <svg class="embed04">
            <use xlink:href="#assyTest"></use>
          </svg>

          <svg class="embed05">
            <use xlink:href="#aging"></use>
          </svg>

          <svg class="embed06">
            <use xlink:href="#cooling"></use>
          </svg>

          <svg class="embed07">
            <use xlink:href="#aoi"></use>
          </svg>

          <svg class="embed08">
            <use xlink:href="#fi"></use>
          </svg>

          <svg class="embed09">
            <use xlink:href="#pullTape"></use>
          </svg>

          <svg class="embed10">
            <use xlink:href="#appAoi"></use>
          </svg>
          <div class="divLineId">14</div>
        </div>

        <div class="div007 trans">
          <div class="div01" id="line15eq1" v-bind:style="{backgroundColor: color}"></div>

          <div class="div02"></div>

          <div class="div03">
            <span id="tooltip15" href="#" data-toggle="popover" data-placement="top" data-html="true" data-template="&lt;div class=&#39;popover&#39; role=&#39;tooltip&#39; style=&#39;border-radius:10px&#39;&gt;&lt;div class=&#39;arrow&#39;&gt;&lt;/div&gt;&lt;h3 class=&#39;popover-header&#39;&gt;&lt;/h3&gt;&lt;div class=&#39;popover-body&#39; style=&#39;background-color:red;color:white;border-radius:10px&#39;&gt;&lt;/div&gt;&lt;/div&gt;" v-bind:data-content="alarmNum">
              <a href="line.html" v-text="id" v-on:click="goLine"></a>
            </span>
          </div>

          <div class="div04"></div>

          <div class="div11" id="line15eq2" v-bind:style="{backgroundColor: color}"></div>

          <div class="div12"></div>

          <div class="div13"></div>

          <div class="div14"></div>

          <div class="div21" id="line15eq3" v-bind:style="{backgroundColor: color}"></div>

          <div class="div22"></div>

          <div class="div23"></div>

          <div class="div24"></div>

          <div class="div31" id="line15eq4" v-bind:style="{backgroundColor: color}"></div>

          <div class="div32"></div>

          <div class="div33"></div>

          <div class="div34"></div>

          <div class="div41" id="line15eq5" v-bind:style="{backgroundColor: color}"></div>

          <div class="div42"></div>

          <div class="div43"></div>

          <div class="div44"></div>

          <div class="div51" id="line15eq6" v-bind:style="{backgroundColor: color}"></div>

          <div class="div52"></div>

          <div class="div53"></div>

          <div class="div54"></div>

          <div class="div61" id="line15eq7" v-bind:style="{backgroundColor: color}"></div>

          <div class="div62"></div>

          <div class="div63"></div>

          <div class="div64"></div>

          <div class="div71" id="line15eq8" v-bind:style="{backgroundColor: color}"></div>

          <div class="div72"></div>

          <div class="div73"></div>

          <div class="div74"></div>

          <div class="div81" id="line15eq9" v-bind:style="{backgroundColor: color}"></div>

          <div class="div82"></div>

          <div class="div83"></div>

          <div class="div84"></div>

          <div class="div91" id="line15eq10" v-bind:style="{backgroundColor: color}"></div>

          <div class="div92"></div>

          <div class="div93"></div>

          <div class="div94"></div>

          <svg class="embed01">
            <use xlink:href="#ohc"></use>
          </svg>

          <svg class="embed02">
            <use xlink:href="#assy"></use>
          </svg>

          <svg class="embed03">
            <use xlink:href="#autoTape"></use>
          </svg>

          <svg class="embed04">
            <use xlink:href="#assyTest"></use>
          </svg>

          <svg class="embed05">
            <use xlink:href="#aging"></use>
          </svg>

          <svg class="embed06">
            <use xlink:href="#cooling"></use>
          </svg>

          <svg class="embed07">
            <use xlink:href="#aoi"></use>
          </svg>

          <svg class="embed08">
            <use xlink:href="#fi"></use>
          </svg>

          <svg class="embed09">
            <use xlink:href="#pullTape"></use>
          </svg>

          <svg class="embed10">
            <use xlink:href="#appAoi"></use>
          </svg>
          <div class="divLineId">15</div>
        </div>

        <div class="div008 trans">
          <div class="div01" id="line16eq1" v-bind:style="{backgroundColor: color}"></div>

          <div class="div02"></div>

          <div class="div03">
            <span id="tooltip16" href="#" data-toggle="popover" data-placement="top" data-html="true" data-template="&lt;div class=&#39;popover&#39; role=&#39;tooltip&#39; style=&#39;border-radius:10px&#39;&gt;&lt;div class=&#39;arrow&#39;&gt;&lt;/div&gt;&lt;h3 class=&#39;popover-header&#39;&gt;&lt;/h3&gt;&lt;div class=&#39;popover-body&#39; style=&#39;background-color:red;color:white;border-radius:10px&#39;&gt;&lt;/div&gt;&lt;/div&gt;" v-bind:data-content="alarmNum">
              <a href="line.html" v-text="id" v-on:click="goLine"></a>
            </span>
          </div>

          <div class="div04"></div>

          <div class="div11" id="line16eq2" v-bind:style="{backgroundColor: color}"></div>

          <div class="div12"></div>

          <div class="div13"></div>

          <div class="div14"></div>

          <div class="div21" id="line16eq3" v-bind:style="{backgroundColor: color}"></div>

          <div class="div22"></div>

          <div class="div23"></div>

          <div class="div24"></div>

          <div class="div31" id="line16eq4" v-bind:style="{backgroundColor: color}"></div>

          <div class="div32"></div>

          <div class="div33"></div>

          <div class="div34"></div>

          <div class="div41" id="line16eq5" v-bind:style="{backgroundColor: color}"></div>

          <div class="div42"></div>

          <div class="div43"></div>

          <div class="div44"></div>

          <div class="div51" id="line16eq6" v-bind:style="{backgroundColor: color}"></div>

          <div class="div52"></div>

          <div class="div53"></div>

          <div class="div54"></div>

          <div class="div61" id="line16eq7" v-bind:style="{backgroundColor: color}"></div>

          <div class="div62"></div>

          <div class="div63"></div>

          <div class="div64"></div>

          <div class="div71" id="line16eq8" v-bind:style="{backgroundColor: color}"></div>

          <div class="div72"></div>

          <div class="div73"></div>

          <div class="div74"></div>

          <div class="div81" id="line16eq9" v-bind:style="{backgroundColor: color}"></div>

          <div class="div82"></div>

          <div class="div83"></div>

          <div class="div84"></div>

          <div class="div91" id="line16eq10" v-bind:style="{backgroundColor: color}"></div>

          <div class="div92"></div>

          <div class="div93"></div>

          <div class="div94"></div>

          <svg class="embed01">
            <use xlink:href="#ohc"></use>
          </svg>

          <svg class="embed02">
            <use xlink:href="#assy"></use>
          </svg>

          <svg class="embed03">
            <use xlink:href="#autoTape"></use>
          </svg>

          <svg class="embed04">
            <use xlink:href="#assyTest"></use>
          </svg>

          <svg class="embed05">
            <use xlink:href="#aging"></use>
          </svg>

          <svg class="embed06">
            <use xlink:href="#cooling"></use>
          </svg>

          <svg class="embed07">
            <use xlink:href="#aoi"></use>
          </svg>

          <svg class="embed08">
            <use xlink:href="#fi"></use>
          </svg>

          <svg class="embed09">
            <use xlink:href="#pullTape"></use>
          </svg>

          <svg class="embed10">
            <use xlink:href="#appAoi"></use>
          </svg>
          <div class="divLineId">16</div>
        </div>

        <div class="div009 trans">
          <div class="div01" id="line17eq2" v-bind:style="{backgroundColor: color}"></div>

          <div class="div02"></div>

          <div class="div03">
            <span id="tooltip17" href="#" data-toggle="popover" data-placement="top" data-html="true" data-template="&lt;div class=&#39;popover&#39; role=&#39;tooltip&#39; style=&#39;border-radius:10px&#39;&gt;&lt;div class=&#39;arrow&#39;&gt;&lt;/div&gt;&lt;h3 class=&#39;popover-header&#39;&gt;&lt;/h3&gt;&lt;div class=&#39;popover-body&#39; style=&#39;background-color:red;color:white;border-radius:10px&#39;&gt;&lt;/div&gt;&lt;/div&gt;" v-bind:data-content="alarmNum">
              <a v-text="id"></a>
            </span>
          </div>

          <div class="div71 div7000" id="line17eq7" v-bind:style="{backgroundColor: color}"></div>

          <div class="div72 div7000"></div>

          <div class="div73 div7000"></div>

          <div class="div74 div7000"></div>

          <div class="div04"></div>

          <svg class="embed02 embed020">
            <use xlink:href="#assy"></use>
          </svg>

          <svg class="embed08 embed080">
            <use xlink:href="#fi"></use>
          </svg>
          <div class="divLineId">17</div>
        </div>

        <div class="div010 trans">
          <div class="div01" id="line18eq2" v-bind:style="{backgroundColor: color}"></div>

          <div class="div02"></div>

          <div class="div03">
            <span id="tooltip18" href="#" data-toggle="popover" data-placement="top" data-html="true" data-template="&lt;div class=&#39;popover&#39; role=&#39;tooltip&#39; style=&#39;border-radius:10px&#39;&gt;&lt;div class=&#39;arrow&#39;&gt;&lt;/div&gt;&lt;h3 class=&#39;popover-header&#39;&gt;&lt;/h3&gt;&lt;div class=&#39;popover-body&#39; style=&#39;background-color:red;color:white;border-radius:10px&#39;&gt;&lt;/div&gt;&lt;/div&gt;" v-bind:data-content="alarmNum">
              <a v-text="id"></a>
            </span>
          </div>

          <div class="div71 div7000" id="line18eq7" v-bind:style="{backgroundColor: color}"></div>

          <div class="div72 div7000"></div>

          <div class="div73 div7000"></div>

          <div class="div74 div7000"></div>

          <div class="div04"></div>

          <svg class="embed02 embed020">
            <use xlink:href="#assy"></use>
          </svg>

          <svg class="embed08 embed080">
            <use xlink:href="#fi"></use>
          </svg>
          <div class="divLineId">18</div>
        </div>
        <div class="flag" style="margin-top: 120px;">二楼</div>

        <ul id="colorStyle" class="colorStyle">
          <li>
            <div v-bind:style="{backgroundColor: runColor}">运行</div>
          </li>

          <li>
            <div v-bind:style="{backgroundColor: downColor}">宕机</div>
          </li>

          <li>
            <div v-bind:style="{backgroundColor: idleColor}">空闲</div>
          </li>

          <li>
            <div v-bind:style="{backgroundColor: pmColor}">维护</div>
          </li>
        </ul>
      </div>
    </div>

    <div class="level2">
      <div class="floor" style="opacity: 1; height: 500px;">
        <div class="div000 trans">
          <div class="div01" id="line22eq2" v-bind:style="{backgroundColor: color}"></div>

          <div class="div02"></div>

          <div class="div03">
            <span id="tooltip22" href="#" data-toggle="popover" data-placement="top" data-html="true" data-template="&lt;div class=&#39;popover&#39; role=&#39;tooltip&#39; style=&#39;border-radius:10px&#39;&gt;&lt;div class=&#39;arrow&#39;&gt;&lt;/div&gt;&lt;h3 class=&#39;popover-header&#39;&gt;&lt;/h3&gt;&lt;div class=&#39;popover-body&#39; style=&#39;background-color:red;color:white;border-radius:10px&#39;&gt;&lt;/div&gt;&lt;/div&gt;" v-bind:data-content="alarmNum">
              <a v-text="id"></a>
            </span>
          </div>

          <div class="div71 div7000" id="line22eq7" v-bind:style="{backgroundColor: color}"></div>

          <div class="div72 div7000"></div>

          <div class="div73 div7000"></div>

          <div class="div74 div7000"></div>

          <div class="div04"></div>

          <svg class="embed02 embed020">
            <use xlink:href="#assy"></use>
          </svg>

          <svg class="embed08 embed080">
            <use xlink:href="#fi"></use>
          </svg>
          <div class="divLineId">22</div>
        </div>

        <div class="div001 trans">
          <div class="div01" id="line23eq1" v-bind:style="{backgroundColor: color}"></div>

          <div class="div02"></div>

          <div class="div03">
            <span id="tooltip23" href="#" data-toggle="popover" data-placement="top" data-html="true" data-template="&lt;div class=&#39;popover&#39; role=&#39;tooltip&#39; style=&#39;border-radius:10px&#39;&gt;&lt;div class=&#39;arrow&#39;&gt;&lt;/div&gt;&lt;h3 class=&#39;popover-header&#39;&gt;&lt;/h3&gt;&lt;div class=&#39;popover-body&#39; style=&#39;background-color:red;color:white;border-radius:10px&#39;&gt;&lt;/div&gt;&lt;/div&gt;" v-bind:data-content="alarmNum">
              <a href="line.html" v-text="id" v-on:click="goLine"></a>
            </span>
          </div>

          <div class="div04"></div>

          <div class="div11" id="line23eq2" v-bind:style="{backgroundColor: color}"></div>

          <div class="div12"></div>

          <div class="div13"></div>

          <div class="div14"></div>

          <div class="div21" id="line23eq3" v-bind:style="{backgroundColor: color}"></div>

          <div class="div22"></div>

          <div class="div23"></div>

          <div class="div24"></div>

          <div class="div31" id="line23eq4" v-bind:style="{backgroundColor: color}"></div>

          <div class="div32"></div>

          <div class="div33"></div>

          <div class="div34"></div>

          <div class="div41" id="line23eq5" v-bind:style="{backgroundColor: color}"></div>

          <div class="div42"></div>

          <div class="div43"></div>

          <div class="div44"></div>

          <div class="div51" id="line23eq6" v-bind:style="{backgroundColor: color}"></div>

          <div class="div52"></div>

          <div class="div53"></div>

          <div class="div54"></div>

          <div class="div61" id="line23eq7" v-bind:style="{backgroundColor: color}"></div>

          <div class="div62"></div>

          <div class="div63"></div>

          <div class="div64"></div>

          <div class="div71" id="line23eq8" v-bind:style="{backgroundColor: color}"></div>

          <div class="div72"></div>

          <div class="div73"></div>

          <div class="div74"></div>

          <div class="div81" id="line23eq9" v-bind:style="{backgroundColor: color}"></div>

          <div class="div82"></div>

          <div class="div83"></div>

          <div class="div84"></div>

          <div class="div91" id="line23eq10" v-bind:style="{backgroundColor: color}"></div>

          <div class="div92"></div>

          <div class="div93"></div>

          <div class="div94"></div>

          <svg class="embed01">
            <use xlink:href="#ohc"></use>
          </svg>

          <svg class="embed02">
            <use xlink:href="#assy"></use>
          </svg>

          <svg class="embed03">
            <use xlink:href="#autoTape"></use>
          </svg>

          <svg class="embed04">
            <use xlink:href="#assyTest"></use>
          </svg>

          <svg class="embed05">
            <use xlink:href="#aging"></use>
          </svg>

          <svg class="embed06">
            <use xlink:href="#cooling"></use>
          </svg>

          <svg class="embed07">
            <use xlink:href="#aoi"></use>
          </svg>

          <svg class="embed08">
            <use xlink:href="#fi"></use>
          </svg>

          <svg class="embed09">
            <use xlink:href="#pullTape"></use>
          </svg>

          <svg class="embed10">
            <use xlink:href="#appAoi"></use>
          </svg>
          <div class="divLineId">23</div>
        </div>

        <div class="div002 trans">
          <div class="div01" id="line24eq1" v-bind:style="{backgroundColor: color}"></div>

          <div class="div02"></div>

          <div class="div03">
            <span id="tooltip24" href="#" data-toggle="popover" data-placement="top" data-html="true" data-template="&lt;div class=&#39;popover&#39; role=&#39;tooltip&#39; style=&#39;border-radius:10px&#39;&gt;&lt;div class=&#39;arrow&#39;&gt;&lt;/div&gt;&lt;h3 class=&#39;popover-header&#39;&gt;&lt;/h3&gt;&lt;div class=&#39;popover-body&#39; style=&#39;background-color:red;color:white;border-radius:10px&#39;&gt;&lt;/div&gt;&lt;/div&gt;" v-bind:data-content="alarmNum">
              <a href="line.html" v-text="id" v-on:click="goLine"></a>
            </span>
          </div>

          <div class="div04"></div>

          <div class="div11" id="line24eq2" v-bind:style="{backgroundColor: color}"></div>

          <div class="div12"></div>

          <div class="div13"></div>

          <div class="div14"></div>

          <div class="div21" id="line24eq3" v-bind:style="{backgroundColor: color}"></div>

          <div class="div22"></div>

          <div class="div23"></div>

          <div class="div24"></div>

          <div class="div31" id="line24eq4" v-bind:style="{backgroundColor: color}"></div>

          <div class="div32"></div>

          <div class="div33"></div>

          <div class="div34"></div>

          <div class="div41" id="line24eq5" v-bind:style="{backgroundColor: color}"></div>

          <div class="div42"></div>

          <div class="div43"></div>

          <div class="div44"></div>

          <div class="div51" id="line24eq6" v-bind:style="{backgroundColor: color}"></div>

          <div class="div52"></div>

          <div class="div53"></div>

          <div class="div54"></div>

          <div class="div61" id="line24eq7" v-bind:style="{backgroundColor: color}"></div>

          <div class="div62"></div>

          <div class="div63"></div>

          <div class="div64"></div>

          <div class="div71" id="line24eq8" v-bind:style="{backgroundColor: color}"></div>

          <div class="div72"></div>

          <div class="div73"></div>

          <div class="div74"></div>

          <div class="div81" id="line24eq9" v-bind:style="{backgroundColor: color}"></div>

          <div class="div82"></div>

          <div class="div83"></div>

          <div class="div84"></div>

          <div class="div91" id="line24eq10" v-bind:style="{backgroundColor: color}"></div>

          <div class="div92"></div>

          <div class="div93"></div>

          <div class="div94"></div>

          <svg class="embed01">
            <use xlink:href="#ohc"></use>
          </svg>

          <svg class="embed02">
            <use xlink:href="#assy"></use>
          </svg>

          <svg class="embed03">
            <use xlink:href="#autoTape"></use>
          </svg>

          <svg class="embed04">
            <use xlink:href="#assyTest"></use>
          </svg>

          <svg class="embed05">
            <use xlink:href="#aging"></use>
          </svg>

          <svg class="embed06">
            <use xlink:href="#cooling"></use>
          </svg>

          <svg class="embed07">
            <use xlink:href="#aoi"></use>
          </svg>

          <svg class="embed08">
            <use xlink:href="#fi"></use>
          </svg>

          <svg class="embed09">
            <use xlink:href="#pullTape"></use>
          </svg>

          <svg class="embed10">
            <use xlink:href="#appAoi"></use>
          </svg>
          <div class="divLineId">24</div>
        </div>

        <div class="div003 trans">
          <div class="div01" id="line25eq1" v-bind:style="{backgroundColor: color}"></div>

          <div class="div02"></div>

          <div class="div03">
            <span id="tooltip25" href="#" data-toggle="popover" data-placement="top" data-html="true" data-template="&lt;div class=&#39;popover&#39; role=&#39;tooltip&#39; style=&#39;border-radius:10px&#39;&gt;&lt;div class=&#39;arrow&#39;&gt;&lt;/div&gt;&lt;h3 class=&#39;popover-header&#39;&gt;&lt;/h3&gt;&lt;div class=&#39;popover-body&#39; style=&#39;background-color:red;color:white;border-radius:10px&#39;&gt;&lt;/div&gt;&lt;/div&gt;" v-bind:data-content="alarmNum">
              <a href="line.html" v-text="id" v-on:click="goLine"></a>
            </span>
          </div>

          <div class="div04"></div>

          <div class="div11" id="line25eq2" v-bind:style="{backgroundColor: color}"></div>

          <div class="div12"></div>

          <div class="div13"></div>

          <div class="div14"></div>

          <div class="div21" id="line25eq3" v-bind:style="{backgroundColor: color}"></div>

          <div class="div22"></div>

          <div class="div23"></div>

          <div class="div24"></div>

          <div class="div31" id="line25eq4" v-bind:style="{backgroundColor: color}"></div>

          <div class="div32"></div>

          <div class="div33"></div>

          <div class="div34"></div>

          <div class="div41" id="line25eq5" v-bind:style="{backgroundColor: color}"></div>

          <div class="div42"></div>

          <div class="div43"></div>

          <div class="div44"></div>

          <div class="div51" id="line25eq6" v-bind:style="{backgroundColor: color}"></div>

          <div class="div52"></div>

          <div class="div53"></div>

          <div class="div54"></div>

          <div class="div61" id="line25eq7" v-bind:style="{backgroundColor: color}"></div>

          <div class="div62"></div>

          <div class="div63"></div>

          <div class="div64"></div>

          <div class="div71" id="line25eq8" v-bind:style="{backgroundColor: color}"></div>

          <div class="div72"></div>

          <div class="div73"></div>

          <div class="div74"></div>

          <div class="div81" id="line25eq9" v-bind:style="{backgroundColor: color}"></div>

          <div class="div82"></div>

          <div class="div83"></div>

          <div class="div84"></div>

          <div class="div91" id="line25eq10" v-bind:style="{backgroundColor: color}"></div>

          <div class="div92"></div>

          <div class="div93"></div>

          <div class="div94"></div>

          <svg class="embed01">
            <use xlink:href="#ohc"></use>
          </svg>

          <svg class="embed02">
            <use xlink:href="#assy"></use>
          </svg>

          <svg class="embed03">
            <use xlink:href="#autoTape"></use>
          </svg>

          <svg class="embed04">
            <use xlink:href="#assyTest"></use>
          </svg>

          <svg class="embed05">
            <use xlink:href="#aging"></use>
          </svg>

          <svg class="embed06">
            <use xlink:href="#cooling"></use>
          </svg>

          <svg class="embed07">
            <use xlink:href="#aoi"></use>
          </svg>

          <svg class="embed08">
            <use xlink:href="#fi"></use>
          </svg>

          <svg class="embed09">
            <use xlink:href="#pullTape"></use>
          </svg>

          <svg class="embed10">
            <use xlink:href="#appAoi"></use>
          </svg>
          <div class="divLineId">25</div>
        </div>

        <div class="div004 trans">
          <div class="div01" id="line26eq1" v-bind:style="{backgroundColor: color}"></div>

          <div class="div02"></div>

          <div class="div03">
            <span id="tooltip26" href="#" data-toggle="popover" data-placement="top" data-html="true" data-template="&lt;div class=&#39;popover&#39; role=&#39;tooltip&#39; style=&#39;border-radius:10px&#39;&gt;&lt;div class=&#39;arrow&#39;&gt;&lt;/div&gt;&lt;h3 class=&#39;popover-header&#39;&gt;&lt;/h3&gt;&lt;div class=&#39;popover-body&#39; style=&#39;background-color:red;color:white;border-radius:10px&#39;&gt;&lt;/div&gt;&lt;/div&gt;" v-bind:data-content="alarmNum">
              <a href="line.html" v-text="id" v-on:click="goLine"></a>
            </span>
          </div>

          <div class="div04"></div>

          <div class="div11" id="line26eq2" v-bind:style="{backgroundColor: color}"></div>

          <div class="div12"></div>

          <div class="div13"></div>

          <div class="div14"></div>

          <div class="div21" id="line26eq3" v-bind:style="{backgroundColor: color}"></div>

          <div class="div22"></div>

          <div class="div23"></div>

          <div class="div24"></div>

          <div class="div31" id="line26eq4" v-bind:style="{backgroundColor: color}"></div>

          <div class="div32"></div>

          <div class="div33"></div>

          <div class="div34"></div>

          <div class="div41" id="line26eq5" v-bind:style="{backgroundColor: color}"></div>

          <div class="div42"></div>

          <div class="div43"></div>

          <div class="div44"></div>

          <div class="div51" id="line26eq6" v-bind:style="{backgroundColor: color}"></div>

          <div class="div52"></div>

          <div class="div53"></div>

          <div class="div54"></div>

          <div class="div61" id="line26eq7" v-bind:style="{backgroundColor: color}"></div>

          <div class="div62"></div>

          <div class="div63"></div>

          <div class="div64"></div>

          <div class="div71" id="line26eq8" v-bind:style="{backgroundColor: color}"></div>

          <div class="div72"></div>

          <div class="div73"></div>

          <div class="div74"></div>

          <div class="div81" id="line26eq9" v-bind:style="{backgroundColor: color}"></div>

          <div class="div82"></div>

          <div class="div83"></div>

          <div class="div84"></div>

          <div class="div91" id="line26eq10" v-bind:style="{backgroundColor: color}"></div>

          <div class="div92"></div>

          <div class="div93"></div>

          <div class="div94"></div>

          <svg class="embed01">
            <use xlink:href="#ohc"></use>
          </svg>

          <svg class="embed02">
            <use xlink:href="#assy"></use>
          </svg>

          <svg class="embed03">
            <use xlink:href="#autoTape"></use>
          </svg>

          <svg class="embed04">
            <use xlink:href="#assyTest"></use>
          </svg>

          <svg class="embed05">
            <use xlink:href="#aging"></use>
          </svg>

          <svg class="embed06">
            <use xlink:href="#cooling"></use>
          </svg>

          <svg class="embed07">
            <use xlink:href="#aoi"></use>
          </svg>

          <svg class="embed08">
            <use xlink:href="#fi"></use>
          </svg>

          <svg class="embed09">
            <use xlink:href="#pullTape"></use>
          </svg>

          <svg class="embed10">
            <use xlink:href="#appAoi"></use>
          </svg>
          <div class="divLineId">26</div>
        </div>

        <div class="div005 trans">
          <div class="div01" id="line27eq1" v-bind:style="{backgroundColor: color}"></div>

          <div class="div02"></div>

          <div class="div03">
            <span id="tooltip27" href="#" data-toggle="popover" data-placement="top" data-html="true" data-template="&lt;div class=&#39;popover&#39; role=&#39;tooltip&#39; style=&#39;border-radius:10px&#39;&gt;&lt;div class=&#39;arrow&#39;&gt;&lt;/div&gt;&lt;h3 class=&#39;popover-header&#39;&gt;&lt;/h3&gt;&lt;div class=&#39;popover-body&#39; style=&#39;background-color:red;color:white;border-radius:10px&#39;&gt;&lt;/div&gt;&lt;/div&gt;" v-bind:data-content="alarmNum">
              <a href="line.html" v-text="id" v-on:click="goLine"></a>
            </span>
          </div>

          <div class="div04"></div>

          <div class="div11" id="line27eq2" v-bind:style="{backgroundColor: color}"></div>

          <div class="div12"></div>

          <div class="div13"></div>

          <div class="div14"></div>

          <div class="div21" id="line27eq3" v-bind:style="{backgroundColor: color}"></div>

          <div class="div22"></div>

          <div class="div23"></div>

          <div class="div24"></div>

          <div class="div31" id="line27eq4" v-bind:style="{backgroundColor: color}"></div>

          <div class="div32"></div>

          <div class="div33"></div>

          <div class="div34"></div>

          <div class="div41" id="line27eq5" v-bind:style="{backgroundColor: color}"></div>

          <div class="div42"></div>

          <div class="div43"></div>

          <div class="div44"></div>

          <div class="div51" id="line27eq6" v-bind:style="{backgroundColor: color}"></div>

          <div class="div52"></div>

          <div class="div53"></div>

          <div class="div54"></div>

          <div class="div61" id="line27eq7" v-bind:style="{backgroundColor: color}"></div>

          <div class="div62"></div>

          <div class="div63"></div>

          <div class="div64"></div>

          <div class="div71" id="line27eq8" v-bind:style="{backgroundColor: color}"></div>

          <div class="div72"></div>

          <div class="div73"></div>

          <div class="div74"></div>

          <div class="div81" id="line27eq9" v-bind:style="{backgroundColor: color}"></div>

          <div class="div82"></div>

          <div class="div83"></div>

          <div class="div84"></div>

          <div class="div91" id="line27eq10" v-bind:style="{backgroundColor: color}"></div>

          <div class="div92"></div>

          <div class="div93"></div>

          <div class="div94"></div>

          <svg class="embed01">
            <use xlink:href="#ohc"></use>
          </svg>

          <svg class="embed02">
            <use xlink:href="#assy"></use>
          </svg>

          <svg class="embed03">
            <use xlink:href="#autoTape"></use>
          </svg>

          <svg class="embed04">
            <use xlink:href="#assyTest"></use>
          </svg>

          <svg class="embed05">
            <use xlink:href="#aging"></use>
          </svg>

          <svg class="embed06">
            <use xlink:href="#cooling"></use>
          </svg>

          <svg class="embed07">
            <use xlink:href="#aoi"></use>
          </svg>

          <svg class="embed08">
            <use xlink:href="#fi"></use>
          </svg>

          <svg class="embed09">
            <use xlink:href="#pullTape"></use>
          </svg>

          <svg class="embed10">
            <use xlink:href="#appAoi"></use>
          </svg>
          <div class="divLineId">27</div>
        </div>

        <div class="div006 trans">
          <div class="div01" id="line28eq2" v-bind:style="{backgroundColor: color}"></div>

          <div class="div02"></div>

          <div class="div03">
            <span id="tooltip28" href="#" data-toggle="popover" data-placement="top" data-html="true" data-template="&lt;div class=&#39;popover&#39; role=&#39;tooltip&#39; style=&#39;border-radius:10px&#39;&gt;&lt;div class=&#39;arrow&#39;&gt;&lt;/div&gt;&lt;h3 class=&#39;popover-header&#39;&gt;&lt;/h3&gt;&lt;div class=&#39;popover-body&#39; style=&#39;background-color:red;color:white;border-radius:10px&#39;&gt;&lt;/div&gt;&lt;/div&gt;" v-bind:data-content="alarmNum">
              <a v-text="id"></a>
            </span>
          </div>

          <div class="div71 div7000" id="line28eq7" v-bind:style="{backgroundColor: color}"></div>

          <div class="div72 div7000"></div>

          <div class="div73 div7000"></div>

          <div class="div74 div7000"></div>

          <div class="div04"></div>

          <svg class="embed02 embed020">
            <use xlink:href="#assy"></use>
          </svg>

          <svg class="embed08 embed080">
            <use xlink:href="#fi"></use>
          </svg>
          <div class="divLineId">28</div>
        </div>

        <div class="div007 trans">
          <div class="div01" id="line29eq2" v-bind:style="{backgroundColor: color}"></div>

          <div class="div02"></div>

          <div class="div03">
            <span id="tooltip29" href="#" data-toggle="popover" data-placement="top" data-html="true" data-template="&lt;div class=&#39;popover&#39; role=&#39;tooltip&#39; style=&#39;border-radius:10px&#39;&gt;&lt;div class=&#39;arrow&#39;&gt;&lt;/div&gt;&lt;h3 class=&#39;popover-header&#39;&gt;&lt;/h3&gt;&lt;div class=&#39;popover-body&#39; style=&#39;background-color:red;color:white;border-radius:10px&#39;&gt;&lt;/div&gt;&lt;/div&gt;" v-bind:data-content="alarmNum">
              <a v-text="id"></a>
            </span>
          </div>

          <div class="div71 div7000" id="line29eq7" v-bind:style="{backgroundColor: color}"></div>

          <div class="div72 div7000"></div>

          <div class="div73 div7000"></div>

          <div class="div74 div7000"></div>

          <div class="div04"></div>

          <svg class="embed02 embed020">
            <use xlink:href="#assy"></use>
          </svg>

          <svg class="embed08 embed080">
            <use xlink:href="#fi"></use>
          </svg>
          <div class="divLineId">29</div>
        </div>
        <div class="flag">三楼</div>

        <ul id="colorStyle1" class="colorStyle">
          <li>
            <div v-bind:style="{backgroundColor: runColor}">运行</div>
          </li>

          <li>
            <div v-bind:style="{backgroundColor: downColor}">宕机</div>
          </li>

          <li>
            <div v-bind:style="{backgroundColor: idleColor}">空闲</div>
          </li>

          <li>
            <div v-bind:style="{backgroundColor: pmColor}">维护</div>
          </li>
        </ul>
      </div>
    </div>

    <div class="level3">
      <div class="floor" style="height: 70px; color: blue">
        <div class="div000 eqpNameCol">
          <div style="text-align: center; width: 100px; height: 30px; color:#000; position: absolute; top:0; left: 20px">OHC</div>
          <div style="text-align: center; width: 145px; height: 30px; color:#000; position: absolute; top:0; left: 160px">Assy</div>
          <div style="text-align: center; width: 50px; height: 30px; color:#000; position: absolute; top:0; left: 282px">AutoTape</div>
          <div style="text-align: center; width: 150px; height: 30px; position: absolute; top:0; left: 405px">AssyTest</div>
          <div style="text-align: center; width: 250px; height: 30px; position: absolute; top:0; left: 530px">Aging</div>
          <div style="text-align: center; width: 150px; height: 30px; position: absolute; top:0; left: 800px">CL</div>
          <div style="text-align: center; width: 100px; height: 30px; position: absolute; top:0; left: 970px">FI AOI</div>
          <div style="text-align: center; width: 250px; height: 30px; position: absolute; top:0; left: 1090px">FT</div>
          <div style="text-align: center; width: 50px; height: 30px; position: absolute; top:0; left: 1335px">Affix</div>
          <div style="text-align: center; width: 50px; height: 30px; position: absolute; top:0; left: 1415px">AppAOI</div>
        </div>
      </div>
    </div>

    <div class="level4">
      <div class="floor" style="height: 89px;">
        <div id="statusColor" class="eqpNameCol" style="margin-top: 20px; color:#000;">
          <div style="display: inline-block; font-size: 30px; font-weight: bold;">状态:</div>
          <div v-bind:style="{backgroundColor: runColor,color: 'white',width: '350px', display: 'inline-block'}">RUN</div>
          <div v-bind:style="{backgroundColor: downColor,color: 'white',width: '350px', display: 'inline-block'}">DOWN</div>
          <div v-bind:style="{backgroundColor: idleColor,color: 'white',width: '350px', display: 'inline-block'}">IDLE</div>
          <div v-bind:style="{backgroundColor: pmColor, color: 'white',width: '350px', display: 'inline-block'}">PM</div>
        </div>
      </div>
    </div>

    <!-- <div class="right"> -->

    <div class="canvasContainer">
      <div class="card main_bg" style="width: 93%; height: 510px;">
        <div class="card-header text-center" id="panel-card-header" style="font-weight: bold">
          Panel 产能
          <span style="font-size: 25px;">(MG151)</span>
        </div>

        <div class="card-body text-center">
          <div id="canvas3" style="height: 360px; width: 100%;"></div>

          <div id="dateNow" style="width:100%;height:30px;text-align: center;font-size: 30px;"></div>
        </div>
      </div>

      <div style="width: 10px;height: 10px;"></div>

      <div class="card main_bg" style="width: 93%; height: 180px;">
        <div class="card-header text-center" id="pallet-card-header" style="font-weight: bold">
          Aging实时温度(AVG)
          <span style="font-size: 25px;">spec:50±5℃</span>
        </div>

        <div class="card-body text-center">
          <table class="table table-bordered table-responsive" style="text-align: center;
                  vertical-align: center; height: 93px; width: 100%;margin-top: -20px;
                  font-size: 25px; line-height: 19px;" id="temperature-avg">
            <thead>
              <tr style="width: 100%;">
                <th style="width: 140px;">Line</th>
                <th style="width: 90px;">8</th>
                <th style="width: 90px;">9</th>
                <th style="width: 90px;">10</th>
                <th style="width: 90px;">11</th>
                <th style="width: 90px;">12</th>
                <th style="width: 90px;">13</th>
                <th style="width: 90px;">14</th>
                <th style="width: 90px;">15</th>
                <th style="width: 90px;">16</th>
                <th style="width: 90px;">23</th>
                <th style="width: 90px;">24</th>
                <th style="width: 90px;">25</th>
                <th style="width: 90px;">26</th>
                <th style="width: 90px;">27</th>
              </tr>
            </thead>

            <tbody>
              <tr v-for="item in temperatureObj" v-bind:key="item.title.avg">
                <th v-text="item.title.avg"></th>

                <td v-text="item.line8.avg"></td>

                <td v-text="item.line9.avg"></td>

                <td v-text="item.line10.avg"></td>

                <td v-text="item.line11.avg"></td>

                <td v-text="item.line12.avg"></td>

                <td v-text="item.line13.avg"></td>

                <td v-text="item.line14.avg"></td>

                <td v-text="item.line15.avg"></td>

                <td v-text="item.line16.avg"></td>

                <td v-text="item.line23.avg"></td>

                <td v-text="item.line24.avg"></td>

                <td v-text="item.line25.avg"></td>

                <td v-text="item.line26.avg"></td>

                <td v-text="item.line27.avg"></td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>

      <div style="width: 10px;height: 10px;"></div>

      <div class="card main_bg" style="width: 93%; height: 500px;">
        <div class="card-header text-center" id="pallet-card-header" style="font-weight: bold">实时报警信息</div>

        <div class="card-body text-center">
          <table class="table table-striped table-bordered table-hover table-responsive" style="text-align: center;
                  vertical-align: center; height: 413px; width: 100%;margin-top: -20px;
                  font-size: 25px; line-height: 20px;" id="current-alarm">
            <thead>
              <tr style="width: 100%;">
                <th style="width: 90px;">Line</th>
                <th style="width: 230px;">Unit</th>
                <th style="width: 100px;">Code</th>
                <th style="width: 700px;">Alarm Description</th>
                <th style="width: 280px;">Occured Time</th>
              </tr>
            </thead>

            <tbody>
              <tr v-for="item in alarmObj" v-bind:key="item.lineID">
                <th v-text="item.lineID"></th>

                <td v-text="item.unit"></td>

                <th v-text="item.code"></th>

                <td v-text="item.desc"></td>

                <td v-text="item.occuredTime"></td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>

      <div style="width: 10px;height: 10px;"></div>

      <div class="card main_bg" id="line-count-div" style="width: 93%; height: 130px; font-size: 30px">
        <div class="card-header text-center" style="font-weight: bold;">监测运行线体数量</div>
        <div class="card-body text-center" style="margin-top: -20px; font-weight: bold;">19</div>
      </div>
    </div>

    <!-- </div> -->
  </div>
</div>
</template>

<script>
export default {

}
</script>

<style>
* {
    box-sizing: border-box;
}
.div000 {
    position: absolute;
    top: 10px;
    left: 210px;
}
.div001 {
    position: absolute;
    top: 70px;
    left: 210px;
}
.div002 {
    position: absolute;
    top: 130px;
    left: 210px;
}
.div003 {
    position: absolute;
    top: 190px;
    left: 210px;
}
.div004 {
    position: absolute;
    top: 250px;
    left: 210px;
}
.div005 {
    position: absolute;
    top: 310px;
    left: 210px;
}
.div006 {
    position: absolute;
    top: 370px;
    left: 210px;
}
.div007 {
    position: absolute;
    top: 430px;
    left: 210px;
}
.div008 {
    position: absolute;
    top: 490px;
    left: 210px
}
.div009 {
    position: absolute;
    top: 550px;
    left: 210px;
}
.div010 {
    position: absolute;
    top: 610px;
    left: 210px;
}
.div01 {
    position: absolute;
    transform: skew(60deg, 0deg);
    width: 150px;
    height: 18px;
    margin-top: 0;
    margin-left: 0;
    border-left: 2px solid #999;
    border-right: 3px solid #999;
    border-top: 1px solid #999;
    border-bottom: 1px solid #999;
}
.div02 {
    position: absolute;
    transform: skew(60deg, 0deg);
    width: 150px;
    height: 18px;
    border-left: 1px dashed #999;
    border-right: 3px solid #999;
    border-top: 1px dashed #999;
    border-bottom: 1px solid #999;
    margin-top: 30px;
    margin-left: 0;
    box-shadow: -10px 5px 5px #888888;
}
.div03 {
    position: absolute;
    transform: skew(0deg, 30deg);
    border: 2px solid #999;
    width: 30px;
    height: 30px;
    margin-top: 9px;
    margin-left: -15px;
    color: #111;
    font-size: 20px;
    text-align: center;
    padding: 2px 0;
}
.div04 {
    position: absolute;
    transform: skew(0deg, 30deg);
    border-left: 1px dashed #999;
    border-right: 2px solid #999;
    width: 30px;
    height: 30px;
    margin-top: 9px;
    left: 135px;
}
.div11 {
    position: absolute;
    transform: skew(60deg, 0deg);
    width: 150px;
    height: 18px;
    border-left: 2px solid #999;
    border-right: 3px solid #999;
    border-top: 1px solid #999;
    border-bottom: 1px solid #999;
    margin-top: 0;
    left: 170px;
}
.div12 {
    position: absolute;
    transform: skew(60deg, 0deg);
    width: 150px;
    height: 18px;
    border-left: 1px dashed #999;
    border-top: 1px dashed #999;
    border-bottom: 1px dashed #999;
    margin-top: 30px;
    margin-left: 170px;
    box-shadow: -10px 5px 5px #888888;
}
.div13 {
    position: absolute;
    transform: skew(0deg, 30deg);
    border-left: 1px dashed #999;
    border-right: 2px solid #999;
    border-bottom: 2px solid #999;
    width: 30px;
    height: 30px;
    margin-top: 9px;
    margin-left: 305px;
    color: white;
}
.div14 {
    position: absolute;
    transform: skew(0deg, 30deg);
    border-left: 1px dashed #999;
    border-right: 2px solid #999;
    width: 30px;
    height: 30px;
    margin-top: 9px;
    margin-left: 155px;
    color: white;
}
.div21 {
    position: absolute;
    transform: skew(60deg, 0deg);
    width: 50px;
    height: 18px;
    border-left: 2px solid #999;
    border-right: 3px solid #999;
    border-top: 1px solid #999;
    border-bottom: 1px solid #999;
    margin-top: 0;
    left: 340px;
}
.div22 {
    position: absolute;
    transform: skew(60deg, 0deg);
    width: 50px;
    height: 18px;
    border-left: 1px dashed #999;
    border-top: 1px dashed #999;
    border-bottom: 1px dashed #999;
    margin-top: 30px;
    margin-left: 340px;
    box-shadow: -10px 5px 5px #888888;
}
.div23 {
    position: absolute;
    transform: skew(0deg, 30deg);
    border-left: 1px dashed #999;
    border-right: 2px solid #999;
    border-bottom: 2px solid #999;
    width: 30px;
    height: 30px;
    margin-top: 9px;
    margin-left: 375px;
    color: white;
}
.div24 {
    position: absolute;
    transform: skew(0deg, 30deg);
    border-left: 1px dashed #999;
    border-right: 2px solid #999;
    width: 30px;
    height: 30px;
    margin-top: 9px;
    margin-left: 325px;
    color: white;
}
.div31 {
    position: absolute;
    transform: skew(60deg, 0deg);
    width: 100px;
    height: 18px;
    border-left: 2px solid #999;
    border-right: 3px solid #999;
    border-top: 1px solid #999;
    border-bottom: 1px solid #999;
    margin-top: 0;
    left: 410px;
}
.div32 {
    position: absolute;
    transform: skew(60deg, 0deg);
    width: 100px;
    height: 18px;
    border-left: 1px dashed #999;
    border-top: 1px dashed #999;
    border-bottom: 1px dashed #999;
    margin-top: 30px;
    margin-left: 410px;
    box-shadow: -10px 5px 5px #888888;
}
.div33 {
    position: absolute;
    transform: skew(0deg, 30deg);
    border-left: 1px dashed #999;
    border-right: 2px solid #999;
    border-bottom: 2px solid #999;
    width: 30px;
    height: 30px;
    margin-top: 9px;
    margin-left: 495px;
    color: white;
}
.div34 {
    position: absolute;
    transform: skew(0deg, 30deg);
    border-left: 1px dashed #999;
    border-right: 2px solid #999;
    width: 30px;
    height: 30px;
    margin-top: 9px;
    margin-left: 395px;
    color: white;
}
.div41 {
    position: absolute;
    transform: skew(60deg, 0deg);
    width: 250px;
    height: 18px;
    border-left: 2px solid #999;
    border-right: 3px solid #999;
    border-top: 1px solid #999;
    border-bottom: 1px solid #999;
    margin-top: 0;
    margin-left: 530px;
}
.div42 {
    position: absolute;
    transform: skew(60deg, 0deg);
    width: 250px;
    height: 18px;
    border-left: 1px dashed #999;
    border-top: 1px dashed #999;
    border-bottom: 1px dashed #999;
    margin-top: 30px;
    margin-left: 530px;
    box-shadow: -10px 5px 5px #888888;
}
.div43 {
    position: absolute;
    transform: skew(0deg, 30deg);
    border-left: 1px dashed #999;
    border-right: 2px solid #999;
    border-bottom: 2px solid #999;
    width: 30px;
    height: 30px;
    margin-top: 9px;
    margin-left: 765px;
    color: white;
}
.div44 {
    position: absolute;
    transform: skew(0deg, 30deg);
    border-left: 1px dashed #999;
    border-right: 2px solid #999;
    width: 30px;
    height: 30px;
    margin-top: 9px;
    margin-left: 515px;
    color: white;
}
.div51 {
    position: absolute;
    transform: skew(60deg, 0deg);
    width: 150px;
    height: 18px;
    border-left: 2px solid #999;
    border-right: 3px solid #999;
    border-top: 1px solid #999;
    border-bottom: 1px solid #999;
    margin-top: 0;
    margin-left: 800px;
}
.div52 {
    position: absolute;
    transform: skew(60deg, 0deg);
    width: 150px;
    height: 18px;
    border-left: 1px dashed #999;
    border-top: 1px dashed #999;
    border-bottom: 1px dashed #999;
    margin-top: 30px;
    margin-left: 800px;
    box-shadow: -10px 5px 5px #888888;
}
.div53 {
    position: absolute;
    transform: skew(0deg, 30deg);
    border-left: 1px dashed #999;
    border-right: 2px solid #999;
    border-bottom: 2px solid #999;
    width: 30px;
    height: 30px;
    margin-top: 9px;
    margin-left: 935px;
    color: white;
}
.div54 {
    position: absolute;
    transform: skew(0deg, 30deg);
    border-left: 1px dashed #999;
    border-right: 2px solid #999;
    width: 30px;
    height: 30px;
    margin-top: 9px;
    margin-left: 785px;
    color: white;
}
.div61 {
    position: absolute;
    transform: skew(60deg, 0deg);
    width: 100px;
    height: 18px;
    border-left: 2px solid #999;
    border-right: 3px solid #999;
    border-top: 1px solid #999;
    border-bottom: 1px solid #999;
    margin-top: 0;
    margin-left: 970px;
}
.div62 {
    position: absolute;
    transform: skew(60deg, 0deg);
    width: 100px;
    height: 18px;
    border-left: 1px dashed #999;
    border-top: 1px dashed #999;
    border-bottom: 1px dashed #999;
    margin-top: 30px;
    margin-left: 970px;
    box-shadow: -10px 5px 5px #888888;
}
.div63 {
    position: absolute;
    transform: skew(0deg, 30deg);
    border-left: 1px dashed #999;
    border-right: 2px solid #999;
    border-bottom: 2px solid #999;
    width: 30px;
    height: 30px;
    margin-top: 9px;
    margin-left: 1055px;
    color: white;
}
.div64 {
    position: absolute;
    transform: skew(0deg, 30deg);
    border-left: 1px dashed #999;
    border-right: 2px solid #999;
    width: 30px;
    height: 30px;
    margin-top: 9px;
    margin-left: 955px;
    color: white;
}
.div71 {
    position: absolute;
    transform: skew(60deg, 0deg);
    width: 250px;
    height: 18px;
    border-left: 2px solid #999;
    border-right: 3px solid #999;
    border-top: 1px solid #999;
    border-bottom: 1px solid #999;
    margin-top: 0;
    margin-left: 1090px;
}
.div72 {
    position: absolute;
    transform: skew(60deg, 0deg);
    width: 250px;
    height: 18px;
    border-left: 1px dashed #999;
    border-right: 3px dashed #999;
    border-top: 1px dashed #999;
    border-bottom: 1px dashed #999;
    margin-top: 30px;
    margin-left: 1090px;
    box-shadow: -10px 5px 5px #888888;
}
.div73 {
    position: absolute;
    transform: skew(0deg, 30deg);
    border-left: 1px dashed #999;
    border-right: 2px solid #999;
    border-bottom: 2px solid #999;
    width: 30px;
    height: 30px;
    margin-top: 9px;
    margin-left: 1325px;
    color: white;
}
.div74 {
    position: absolute;
    transform: skew(0deg, 30deg);
    border-left: 1px dashed #999;
    border-right: 2px solid #999;
    width: 30px;
    height: 30px;
    margin-top: 9px;
    margin-left: 1075px;
    color: white;
}
.div81 {
    position: absolute;
    transform: skew(60deg, 0deg);
    width: 50px;
    height: 18px;
    border-left: 2px solid #999;
    border-right: 3px solid #999;
    border-top: 1px solid #999;
    border-bottom: 1px solid #999;
    margin-top: 0px;
    margin-left: 1360px;
}
.div82 {
    position: absolute;
    transform: skew(60deg, 0deg);
    width: 50px;
    height: 18px;
    border-left: 1px dashed #999;
    border-top: 1px dashed #999;
    border-bottom: 1px dashed #999;
    margin-top: 30px;
    margin-left: 1360px;
    box-shadow: -10px 5px 5px #888888;
}
.div83 {
    position: absolute;
    transform: skew(0deg, 30deg);
    border-left: 1px dashed #999;
    border-right: 2px solid #999;
    border-bottom: 2px solid #999;
    width: 30px;
    height: 30px;
    margin-top: 9px;
    margin-left: 1395px;
    color: white;
}
.div84 {
    position: absolute;
    transform: skew(0deg, 30deg);
    border-left: 1px dashed #999;
    border-right: 2px solid #999;
    width: 30px;
    height: 30px;
    margin-top: 9px;
    margin-left: 1345px;
    color: white;
}
.div91 {
    position: absolute;
    transform: skew(60deg, 0deg);
    width: 50px;
    height: 18px;
    border-left: 2px solid #999;
    border-right: 3px solid #999;
    border-top: 1px solid #999;
    border-bottom: 1px solid #999;
    margin-top: 0;
    margin-left: 1430px;
}
.div92 {
    position: absolute;
    transform: skew(60deg, 0deg);
    width: 50px;
    height: 18px;
    border-left: 1px dashed #999;
    border-top: 1px dashed #999;
    border-bottom: 1px dashed #999;
    margin-top: 30px;
    margin-left: 1430px;
    box-shadow: -10px 5px 5px #888888;
}
.div93 {
    position: absolute;
    transform: skew(0deg, 30deg);
    border-left: 1px dashed #999;
    border-right: 2px solid #999;
    border-bottom: 2px solid #999;
    width: 30px;
    height: 30px;
    margin-top: 9px;
    margin-left: 1465px;
    color: white;
}
.div94 {
    position: absolute;
    transform: skew(0deg, 30deg);
    border-left: 1px dashed #999;
    border-right: 2px solid #999;
    width: 30px;
    height: 30px;
    margin-top: 9px;
    margin-left: 1615px;
    color: black;
}
.divLineId {
    position: absolute;
    width: 30px;
    height: 30px;
    margin-top: 9px;
    margin-left: 1515px;
    color: black;
    font-size: 25px;
    font-weight: bold;
}
.embed01 {
    position: absolute;
    transform: skew(0deg, 0deg) scale(0.91, 0.32) rotate(0deg);
    left: 0;
    top: -35px;
}
.embed02 {
    position: absolute;
    transform: skew(0deg, 0deg) scale(1.42, 0.32) rotate(0deg);
    left: 246px;
    top: -35px;
}
.embed03 {
    position: absolute;
    transform: skew(0deg, 0deg) scale(0.32, 0.32) rotate(0deg);
    left: 250px;
    top: -35px;
}
.embed04 {
    position: absolute;
    transform: skew(0deg, 0deg) scale(1.0, 0.32) rotate(0deg);
    left: 423px;
    top: -35px;
}
.embed05 {
    position: absolute;
    transform: skew(0deg, 0deg) scale(1.25, 0.32) rotate(0deg);
    left: 580px;
    top: -35px;
}
.embed06 {
    position: absolute;
    transform: skew(0deg, 0deg) scale(0.78, 0.32) rotate(0deg);
    left: 780px;
    top: -35px;
}
.embed07 {
    position: absolute;
    transform: skew(0deg, 0deg) scale(1.05, 0.32) rotate(0deg);
    left: 990px;
    top: -35px;
}
.embed08 {
    position: absolute;
    transform: skew(0deg, 0deg) scale(1.40, 0.32) rotate(0deg);
    left: 1160px;
    top: -35px;
}
.embed09 {
    position: absolute;
    transform: skew(0deg, 0deg) scale(0.32, 0.32) rotate(0deg);
    left: 1270px;
    top: -35px;
}
.embed10 {
    position: absolute;
    transform: skew(0deg, 0deg) scale(0.32, 0.32) rotate(0deg);
    left: 1340px;
    top: -40px;
}
.div7000 {
    top: 0;
    left: -920px;
}
.embed020 {
    top: -35px;
    left: 75px;
}

.embed080 {
    top: -35px;
    left: 240px;
}
.flag {
    position: absolute;
    width: 360px;
    color: #000;
    text-align: center;
    top: 200px;
    left: -100px;
    font-size: 50px;
    font-style: italic;
    font-weight: bold;
    transform: skew(20deg, 0deg) rotate(0deg);
}
.floor {
    position: absolute;
    transform: skew(0deg, 0deg);
    border-left: 1px dashed #999;
    border-right: 1px solid #999;
    border-top: 1px dashed #999;
    border-bottom: 1px solid #999;
    width: 1770px;
    height: 780px;
    top: 60px;
    left: 410px;
    text-align: center;
    color: #bbb;
    /*box-shadow: -20px 6px 20px #888888;*/
}
.trans {
    transform: skew(0deg, 0deg);
}
.wall1 {
    position: absolute;
    transform: skew(25deg, -10deg);
    border: 3px solid #999;
    width: 1410px;
    height: 420px;
    top: -550px;
    left: -410px;
    background-color: #999;
    box-shadow: 10px 30px 30px #888888;
    font-size: 40px;
}
.wall2 {
    position: absolute;
    transform: skew(25deg, 28deg);
    border-left: 3px dashed #999;
    border-right: 3px solid #999;
    border-top: 3px solid #999;
    border-bottom: 3px dashed #999;
    width: 1010px;
    height: 430px;
    top: -410px;
    left: 1000px;
    background-color: #999;
    box-shadow: 0 20px 30px #888888;
}
.level1 {
    position: absolute;
    top: 530px;
    left: -400px;
}
.level2 {
    position: absolute;
    top: -40px;
    left: -400px;
}
.level3 {
    position: absolute;
    top: 460px;
    left: -400px;
}
.level4 {
    position: absolute;
    top: 1220px;
    left: -400px;
}
body {
    /*background:#ead1dc;*/
    overflow: hidden;
}
.root {
    position: relative;
    width: 3240px;
    height: 1500px;
    transform: scale(1.0, 1.0);
    margin: auto;
    /*background-color: #ead1dc;*/
}
.main_bg{
    /*background-color: #ead1dc;*/
}
.card-body {
    padding-left: 0;
    padding-right: 0;
}
.top {
    position: absolute;
    width: 3040px;
    height: 1100px;
    transform: scale(1, 1) skew(0deg, 0deg);
    left: 0;
    top: 0;
}
.canvasContainer {
    position: absolute;
    top: 20px;
    right: -80px;
    z-index: 100;
    width: 1500px;
}
.colorStyle li {
    float: left;
    width: 42px;
    height: 12px;
    list-style-type: none;
    font-size: 40px;
}

.colorStyle li div{
    width: 40px;
    height: 130px;
    text-align: center;
    padding: 12px 0;
}
.colorStyle {
    position: absolute;
    color: #999;
    text-align: center;
    top: 0;
    left: -40px;
    transform: skew(0deg, 0deg) rotate(0deg);
}
.header {
    position: absolute;
    top: 0;
    right: -10px;
    text-align: center;
    padding: 20px;
    z-index: 101;
}
.header span:hover{
    opacity: 0.5;
}
.font_size{
    font-size: 21px;
}
.logo{
    position: absolute;
    left: 5px;
    top: 0px;
    padding-right: 5px;
}
.title {
    /*position: absolute;*/
    /*display: block;*/
    /*top: 0;*/
    margin:auto;
    width: 50%;
    text-align: center;
    z-index: 1000;
}
/*#palletsDay tr td{*/
    /*padding-top: 10px;*/
/*}*/
/*#palletsDay tr th{*/
    /*padding-top: 10px;*/
/*}*/

.eqpNameCol {
    font-size: 28px;
    font-weight: bold;
}

.card-header {
    font-size: 40px;
}

@media only screen and (min-width: 1024px) {
    .root {
        position: relative;
        width: 3240px;
        height: 1500px;
        transform: scale(0.316049, 0.417333);
        margin-left: -1108px;
        margin-right: -1108px;
        margin-top: -437px;
        /*background-color: #ead1dc;*/
    }
}

@media only screen and (min-width: 1366px) {
    .root {
        position: relative;
        width: 3240px;
        height: 1500px;
        transform: scale(0.421605, 0.417333);
        margin-left: -937px;
        margin-right: -937px;
        margin-top: -437px;
        /*background-color: #ead1dc;*/
    }
}

@media only screen and (min-width: 1600px) {
    .root {
        position: relative;
        width: 3240px;
        height: 1500px;
        transform: scale(0.493827, 0.505333);
        margin-left: -820px;
        margin-right: -820px;
        margin-top: -371px;
        /*background-color: #ead1dc;*/
    }
}

@media only screen and (min-width: 1920px) {
    .root {
        position: relative;
        width: 3240px;
        height: 1500px;
        transform: scale(0.592593, 0.625333);
        margin-left: -660px;
        margin-right: -660px;
        margin-top: -281px;
        /*background-color: #ead1dc;*/
    }
}

@media only screen and (min-width: 2560px) {
    .root {
        position: relative;
        width: 3240px;
        height: 1500px;
        transform: scale(0.790123, 0.865333);
        margin-left: -340px;
        margin-right: -340px;
        margin-top: -101px;
        /*background-color: #ead1dc;*/
    }
}

@media only screen and (min-width: 3840px) {
    .root {
        position: relative;
        width: 3240px;
        height: 1500px;
        transform: scale(1.18519, 1.34533);
        margin-left: 300px;
        margin-right: 300px;
        margin-top: 259px;
        /*background-color: #ead1dc;*/
    }
}
</style>
