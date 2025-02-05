### 反向索引堆

数据结构:
哈希表(数组):充当堆元素的反向索引表来改写堆
小根堆：手写， 扩展调整优先级上浮的接口

heap[i][2]:i是行下标，[0]位置是边的下一个终点1，[1]位置是边的权值。
算法流程:
1. 链式前向星建图，初始化堆，初始化反向索引表。
2. 源节点入堆，将其所有边入堆。
3. 弹出堆顶元素， 扫描其所有边， 此时边有三种可能:
    >边从未进入过堆，那么入堆(数组尾插元素+上浮调整)， 同时更新反向索引表
    >边进入过堆，那么考虑更新，如果当前到边的权值更小，那么修改并调整其在堆中位置。
    >边被堆处理过，那么跳过。
4. 重复


算法流程
1. 小根堆存储两个信息， 用一个int[2]数组， 分别是(节点， 到该节点的花费)， 根据该节点的花费组织小根堆。
2. 小根堆弹出(u节点，到达u节点的权值y)， y累加到总权值， 扫描u节点的所有关联边e。
3. >假设，u通过边e到达顶点v, 权重w\
    >- 若当前v已经加入过生成树， 那么跳过该边。
    >- 如果当前v没有在堆上， 入小根堆(添加信息)。
    >- 如果当前v在堆里， 且记录(v,x)：1. 当w<x, 则记录更新成(v,w),然后调整其在小根堆的位置(这里是上浮)，维持小根堆的性质; 2. 如果当前w>=x， 忽略。
4. 重复步骤2和3中的讨论。 