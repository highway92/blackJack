# 블랙잭 게임을 자바로 구현. 

## 게임의 룰

블랙잭은 딜러와 플레이어 간의 게임이다. 플레이어의 목적은 딜러를 이기는 것이며 일반 블랙잭 룰에서 몇가지 부분은 제외하고 구현했다. 코드로 구현한 룰은 다음과 같다. 

### 승리 조건 
1. 블랙잭 게임의 승리조건은 21에 가장 가까운 사람이 이기는것이다. 
2. 만약 딜러와 플레이어가 모두 21일 경우 무승부로 처리된다. 
3. 자신의 카드합이 21을 초과할 경우 Busted되어 자동 패배 처리된다. 
4. 딜러가 Busted될 경우 현재 Busted상태가 아닌 모든 플레이어가 승리한다. 

### 게임 시작 단계 
1. 게임의 최대 참가 인원은 4명이다. 
2. 게임이 시작되면 우선 각 플레이어는 공개된 상태의 카드를 한장 받는다. 
3. 그 후에 딜러가 비공개 상태의 카드를 받는다. 
4. 다시 각 플레이어들은 공개된 상태의 카드를 한장 받는다. 
5. 마지막으로 딜러가 공개된 상태의 카드를 한장 받으며 게임이 시작된다. 

### 게임 진행
1. 시작단계 이후 각 플레이어는 각자의 행동을 할 수 있다. 
2-1 hit는 카드를 한장 더 받는 행동이다. 21에 최대한 가까울수 있도록 카드를 받는다.(Busted되지 않게 주의) 
2-2 stay는 카드를 그만 받겠다는 행동이다. 더 이상 카드를 받지 않으며 다음 플레이어의 차례로 넘어간다. 
3. 모든 플레이어가 행동을 마치면 딜러의 차례다. 
4. 딜러의 행동은 룰베이스로 정해져 있다. 비공개상태인 카드를 공개하여 16이하면 hit, 17이상일 경우 stay 행동을 취한다. 
5. 딜러가 Soft 17일 경우에는 hit할 수도 있다. ** Soft 17이란 1(ACE) 와 6 으로 이루어진 조합으로 ACE카드를 11로 사용하면 17이 된다.

 ### 카드 설명
 조커를 제외한 총 52장의 카드로 구성되며 하트, 스페이드, 클로버, 다이아몬드 각 문양의 1 ~ 10까지의 숫자카드 J,Q,K 카드가 있다. 
 J,Q,K는 숫자 10의 value를 가지며 1(ACE) 카드는 1 또는 11 중 플레이어에게 유리하게 사용할 수 있다.