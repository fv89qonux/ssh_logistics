## 本项目实现的最终作用是基于SSH物流快递管理系统
## 分为2个角色
### 第1个角色为管理员角色，实现了如下功能：
 - 员工增删改查管理
 - 管理员登录
 - 订单查询
 - 财务统计查询
### 第2个角色为员工角色，实现了如下功能：
 - 仓储管理
 - 员工登录
 - 客户增删改查管理
 - 订单增删改查管理
 - 调度管理
 - 车辆管理
## 数据库设计如下：
# 数据库设计文档

**数据库名：** ssh_logistics

**文档版本：** 


| 表名                  | 说明       |
| :---: | :---: |
| [t_caiwu](#t_caiwu) |  |
| [t_cangzu](#t_cangzu) |  |
| [t_cheliang](#t_cheliang) |  |
| [t_churuku](#t_churuku) |  |
| [t_diaodu](#t_diaodu) |  |
| [t_dingchedan](#t_dingchedan) |  |
| [t_dingdan](#t_dingdan) |  |
| [t_kehu](#t_kehu) |  |
| [t_kucun](#t_kucun) |  |
| [t_user](#t_user) | 用户表 |

**表名：** <a id="t_caiwu">t_caiwu</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   bigint   | 20 |   0    |    N     |  Y   |       |   |
|  2   | createTime |   datetime   | 19 |   0    |    Y     |  N   |   NULL    | 创建时间  |
|  3   | jine |   double   | 23 |   0    |    N     |  N   |       |   |
|  4   | leixing |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  5   | TYPE |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 类型  |
|  6   | cheliangid |   bigint   | 20 |   0    |    Y     |  N   |   NULL    |   |
|  7   | churukuid |   bigint   | 20 |   0    |    Y     |  N   |   NULL    |   |
|  8   | dingdanid |   bigint   | 20 |   0    |    Y     |  N   |   NULL    |   |
|  9   | kucunid |   bigint   | 20 |   0    |    Y     |  N   |   NULL    |   |
|  10   | userid |   bigint   | 20 |   0    |    Y     |  N   |   NULL    | 用户ID  |

**表名：** <a id="t_cangzu">t_cangzu</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   bigint   | 20 |   0    |    N     |  Y   |       |   |
|  2   | zujin |   double   | 23 |   0    |    N     |  N   |       |   |

**表名：** <a id="t_cheliang">t_cheliang</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   bigint   | 20 |   0    |    N     |  Y   |       |   |
|  2   | chelianglock |   int   | 10 |   0    |    N     |  N   |       |   |
|  3   | chengyungongsi |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  4   | chepai |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  5   | chexing |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  6   | createTime |   datetime   | 19 |   0    |    Y     |  N   |   NULL    | 创建时间  |
|  7   | diaoduzhuangtai |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  8   | guihao |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |

**表名：** <a id="t_churuku">t_churuku</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   bigint   | 20 |   0    |    N     |  Y   |       |   |
|  2   | createTime |   datetime   | 19 |   0    |    Y     |  N   |   NULL    | 创建时间  |
|  3   | dingdanhao |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 订单号  |
|  4   | jiage |   double   | 23 |   0    |    N     |  N   |       |   |
|  5   | shangpingming |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  6   | shuliang |   int   | 10 |   0    |    N     |  N   |       |   |
|  7   | type |   int   | 10 |   0    |    N     |  N   |       | 类型  |
|  8   | zhanyongmianji |   double   | 23 |   0    |    N     |  N   |       |   |
|  9   | userid |   bigint   | 20 |   0    |    Y     |  N   |   NULL    | 用户ID  |

**表名：** <a id="t_diaodu">t_diaodu</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   bigint   | 20 |   0    |    N     |  Y   |       |   |
|  2   | chengyungongsi |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  3   | createTime |   datetime   | 19 |   0    |    Y     |  N   |   NULL    | 创建时间  |
|  4   | diaoduriqi |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  5   | diaoduzhuangtai |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  6   | xianluming |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  7   | yaoqiudaidashijian |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  8   | yunshufeiyong |   double   | 23 |   0    |    N     |  N   |       |   |
|  9   | cheliangid |   bigint   | 20 |   0    |    Y     |  N   |   NULL    |   |
|  10   | dingchedanid |   bigint   | 20 |   0    |    Y     |  N   |   NULL    |   |
|  11   | dingdanid |   bigint   | 20 |   0    |    Y     |  N   |   NULL    |   |
|  12   | userid |   bigint   | 20 |   0    |    Y     |  N   |   NULL    | 用户ID  |
|  13   | user2id |   bigint   | 20 |   0    |    Y     |  N   |   NULL    |   |
|  14   | user3id |   bigint   | 20 |   0    |    Y     |  N   |   NULL    |   |

**表名：** <a id="t_dingchedan">t_dingchedan</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   bigint   | 20 |   0    |    N     |  Y   |       |   |
|  2   | chuanzhen |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  3   | createTime |   datetime   | 19 |   0    |    Y     |  N   |   NULL    | 创建时间  |
|  4   | dianhua |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 电话  |
|  5   | dingchedanhao |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  6   | dingchexingzhi |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  7   | fenpeizhuangtai |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  8   | lianxiren |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  9   | youjian |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  10   | yunshuxingzhi |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  11   | cheliangid |   bigint   | 20 |   0    |    Y     |  N   |   NULL    |   |
|  12   | dingdanid |   bigint   | 20 |   0    |    Y     |  N   |   NULL    |   |
|  13   | userid |   bigint   | 20 |   0    |    Y     |  N   |   NULL    | 用户ID  |

**表名：** <a id="t_dingdan">t_dingdan</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   bigint   | 20 |   0    |    N     |  Y   |       |   |
|  2   | dingchedangeshu |   int   | 10 |   0    |    N     |  N   |       |   |
|  3   | dingdanhao |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 订单号  |
|  4   | duizhangzhuangtai |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  5   | fahuodi |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  6   | huowubianhao |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  7   | huowumingchen |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  8   | jine |   double   | 23 |   0    |    N     |  N   |       |   |
|  9   | kehuxingming |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  10   | liaxifangshi |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  11   | mianji |   double   | 23 |   0    |    N     |  N   |       |   |
|  12   | mudidi |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  13   | riqi |   datetime   | 19 |   0    |    Y     |  N   |   NULL    | 日期  |
|  14   | shouhuozhuangtai |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  15   | shuliang |   int   | 10 |   0    |    N     |  N   |       |   |
|  16   | tiji |   double   | 23 |   0    |    N     |  N   |       |   |
|  17   | zhongliang |   double   | 23 |   0    |    N     |  N   |       |   |
|  18   | kehuid |   bigint   | 20 |   0    |    Y     |  N   |   NULL    |   |

**表名：** <a id="t_kehu">t_kehu</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   bigint   | 20 |   0    |    N     |  Y   |       |   |
|  2   | createTime |   datetime   | 19 |   0    |    Y     |  N   |   NULL    | 创建时间  |
|  3   | gongsimingchen |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  4   | jiaoyicishu |   int   | 10 |   0    |    N     |  N   |       |   |
|  5   | jiaoyijine |   double   | 23 |   0    |    N     |  N   |       |   |
|  6   | kehulock |   int   | 10 |   0    |    N     |  N   |       |   |
|  7   | kehumingcheng |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |

**表名：** <a id="t_kucun">t_kucun</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   bigint   | 20 |   0    |    N     |  Y   |       |   |
|  2   | bianhao |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 编号  |
|  3   | shangpingming |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  4   | shuliang |   int   | 10 |   0    |    N     |  N   |       |   |

**表名：** <a id="t_user">t_user</a>

**说明：** 用户表

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   bigint   | 20 |   0    |    N     |  Y   |       |   |
|  2   | createTime |   datetime   | 19 |   0    |    Y     |  N   |   NULL    | 创建时间  |
|  3   | password |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 密码  |
|  4   | role |   int   | 10 |   0    |    N     |  N   |       | 角色  |
|  5   | truename |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  6   | userlock |   int   | 10 |   0    |    N     |  N   |       |   |
|  7   | username |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 用户名  |

