import Style from './index.module.css'
import { CardT } from '@/components'
import ReactEcharts from "echarts-for-react"
import echarts from "echarts";

export default function Home() {
  const cardData = [
    {
      name: '总人数',
      // number: detail?.authorCount,
      number: 188,
      imgUrl: 'totality',
    },
    {
      name: '出勤人数',
      number: 178,
      imgUrl: 'work',
    },
    {
      name: '缺勤人数',
      number: 4,
      imgUrl: 'duty',
    },
    {
      name: '请假人数',
      number: 6,
      imgUrl: 'leave',
    },
  ];
  const getOption = () => {
    let option = {
      tooltip: {
        trigger: 'axis'
      },
      xAxis: {
        type: 'category',
        boundaryGap: false,
        data: ['周一', '周二', '周三', '周四', '周五']
      },
      yAxis: {
        type: 'value',
        axisLabel: {
          formatter: '{value}%'
        }
      },
      series: [
        {
          data: [82, 93, 90, 73, 90],
          type: 'line',
          smooth: true
        }
      ]
    };
    return option;
  };
  const dutyOption = {
    tooltip: {
      trigger: 'item'
    },
    legend: {
      top: 'center',
      right: '10%',
      orient: 'vertical',
    },
    series: [
      {
        name: '缺勤人数',
        type: 'pie',
        radius: ['40%', '70%'],
        center:['30%','50%'],
        avoidLabelOverlap: false,
        itemStyle: {
          borderRadius: 10,
          borderColor: 'red',
          borderWidth: 2
        },
        label: {
          show: false,
          position: 'center'
        },
        emphasis: {
          label: {
            show: true,
            fontSize: 20,
            fontWeight: 'bold'
          }
        },
        labelLine: {
          show: false
        },
        data: [
          { value: 13, name: '软件1班' },
          { value: 4, name: '软件2班' },
          { value: 6, name: '软件3班' },
          { value: 10, name: '软件4班' },
          { value: 9, name: '软件5班' }
        ]
      }
    ]
  };

  return (
    <div>
      <CardT title='基础数据'>
        <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr 1fr 1fr', gap: '10px', minWidth: '800px' }}>
          {cardData?.map((data) => {
            return (
              <div className={Style.Basics_cont} style={{ display: 'flex' }} key={data.imgUrl}>
                <div style={{ marginRight: 14, display: 'flex', alignItems: 'center' }}>
                  <img style={{ width: 36 }} src={require(`./image/${data.imgUrl}.png`)} alt="duty icon" />
                </div>
                <div>
                  <h4 className={Style.text1}>{data.name}</h4>
                  <p className={Style.text2}>{data.number}</p>
                </div>
              </div>
            )
          })}
        </div>
      </CardT>
      <CardT mar='10px' title='数据分析'>
        <div className={Style.container}>
          <div className={Style.analysis}>
            <div style={{ fontSize: "16px", fontWeight: '600' }}>本周出勤率</div>
            <ReactEcharts option={getOption()} notMerge={true} />
          </div>
          <div className={Style.analysis}>
            <div style={{ fontSize: "16px", fontWeight: '600' }}>本周各班缺勤人数</div>
            <ReactEcharts option={dutyOption} />
          </div>
        </div>
      </CardT>
    </div>
  )
}
