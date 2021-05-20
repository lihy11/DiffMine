### DiffMine 模式挖掘系统
#### 运行前配置
1. 软件仓库：仓库中包含多个Git管理的项目，不同项目按照文件夹分割，
2. 数据库配置：
    （1） 项目信息表格：保存待挖掘的相关项目，其格式如下：
    | 字段名称 | 字段含义 | 字段类型 |
    |-|-|-|
    | project_id|项目id，唯一的项目标识|varchar|
    | project_name|项目名称|varchar|
    | project_url|项目链接|varchar|
    | last_commit_checked|上次挖掘进行到那一次commit（初始空）|varchar|
    （2）提交变更信息表：保存挖掘到的提交中变更的代码信息
    | 字段名称| 字段含义| 字段类型|
    |-|-|-|
    |varietyinfo_id|单次变更id，自动生成|varchar|
    |project_id|对应的项目id|varchar|
    |project_name|对应的项目名称|varchar|
    |project_commit_id|对应的提交号|varchar|
    |file_path|修改的文件路径，';'分割|varchar(500)|
    |add_possions|增加代码所在的位置,';'分割|varchar|
    |add_widths|增加代码的宽度,';'分割|varchar|
    |del_possions|删除代码所在的位置|varchar|
    |del_widths|删除代码宽度|varchar|
    （3）数据库连接信息保存在configuration.xml中


#### 程序入口
1. `cn.net.cobot.mining.action.RunAnalyze.main()`函数中包含了提取提交部分代码的入口函数
2. `cn.net.cobot.mining.action.ResultAnalyze.main()`函数中包含了从修改代码中挖掘模式的入口函数

#### 部分模式挖掘结果展示：