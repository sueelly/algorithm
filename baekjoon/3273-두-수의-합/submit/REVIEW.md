# 3273번: 두 수의 합 - 코드 리뷰

## 📝 내 코드

```java
public int solve(int n, int[] arr, int x) {
    int[] count = new int[x];
    int result = 0;

    for (int i = 0; i < n; i++) {
        if (arr[i] < x) count[arr[i]]++;
    }
    for (int i = 1; i < (x + 1) / 2; i++) {
        result += count[i] * count[x - i];
    }
    return result;
}
```

## ✅ 분석

### 접근 방식
- **카운팅 배열** 활용
- `count[i]` = 수열에서 값 i의 개수
- `count[i] * count[x-i]` = 합이 x가 되는 쌍의 개수

### 시간 복잡도
- **O(n + x)**: 배열 순회 O(n) + 카운트 계산 O(x/2)

### 공간 복잡도
- **O(x)**: 카운팅 배열 크기 (최대 2,000,000)

### 장점

1. **중복 방지 로직**
   - `(x + 1) / 2`까지만 순회하여 (i, x-i) 쌍을 한 번만 계산
   - 예: x=13일 때 (1,12), (2,11), ... (6,7)만 계산

2. **범위 체크**
   - `arr[i] < x` 조건으로 불필요한 인덱싱 방지
   - x 이상인 값은 어차피 쌍을 만들 수 없음

3. **카운팅 곱셈**
   - 각 값의 개수를 곱해서 조합 수 계산
   - 시간 복잡도 O(n + x)

### 개선 가능한 점

1. **메모리 사용**
   - x가 최대 2,000,000이면 배열 크기 8MB
   - 투 포인터 방식으로 바꾸면 O(1) 공간 사용 가능

2. **x/2일 때 처리 (별도 처리 불필요)**
   - 문제 조건: **"서로 다른"** 양의 정수
   - 따라서 같은 값이 두 번 나올 수 없음 → (x/2, x/2) 쌍은 원래 불가능
   - 현재 코드가 정확함!

---

## 🏆 대표 풀이 1: 투 포인터

```java
public int solve(int n, int[] arr, int x) {
    Arrays.sort(arr);
    
    int left = 0;
    int right = n - 1;
    int count = 0;
    
    while (left < right) {
        int sum = arr[left] + arr[right];
        if (sum == x) {
            count++;
            left++;
            right--;
        } else if (sum < x) {
            left++;
        } else {
            right--;
        }
    }
    return count;
}
```

### 특징
- 정렬 O(n log n) + 투 포인터 O(n) = **O(n log n)**
- 공간 복잡도 **O(1)** (정렬 제외)
- 메모리 효율적

---

## 🏆 대표 풀이 2: boolean 배열 + 순차 체크 (BaaaaaaaaaaarkingDog)

```java
public int solve(int n, int[] arr, int x) {
    // x-arr[i]가 최대 x까지 가능하므로 배열 크기를 x+1로 설정
    boolean[] occur = new boolean[x + 1];
    int ans = 0;
    
    for (int i = 0; i < n; i++) {
        int target = x - arr[i];
        // target이 유효 범위이고, 이전에 나온 적 있으면 쌍 발견
        if (target > 0 && target <= x && occur[target]) {
            ans++;
        }
        // 현재 값이 유효 범위면 존재 표시
        if (arr[i] <= x) {
            occur[arr[i]] = true;
        }
    }
    return ans;
}
```

### 핵심 아이디어
- **순차적으로 처리**: 현재 값을 체크하기 **전에** x-arr[i]가 이미 존재하는지 확인
- **자연스러운 중복 방지**: i < j 조건을 순회 순서로 자동 만족
- 먼저 체크하고, 그 다음 현재 값을 occur에 표시

### 특징
- 시간 복잡도 **O(n)**
- 공간 복잡도 **O(x)**
- 한 번의 순회로 해결 (내 코드는 두 번 순회)

---

## 📊 비교

| 항목 | 내 코드 (카운팅) | 투 포인터 |
|------|-----------------|-----------|
| 시간 복잡도 | O(n + x) | O(n log n) |
| 공간 복잡도 | O(x) | O(1) |
| 메모리 | 8MB (x=2M) | 거의 없음 |
| 중복 수 처리 | ✅ 가능 | ✅ 가능 |
| 구현 난이도 | ⭐⭐ | ⭐⭐⭐ |

---

## 💡 학습 포인트

### 1. Two Sum 변형 문제
- LeetCode Two Sum과 유사하지만 **쌍의 개수**를 구하는 점이 다름
- 중복을 어떻게 처리하느냐가 핵심

### 2. 카운팅 vs 투 포인터
```java
// 카운팅: 값의 범위가 작을 때 유리
int[] count = new int[MAX_VALUE];

// 투 포인터: 메모리 제한이 빡빡할 때 유리
Arrays.sort(arr);
left++; right--;
```

### 3. 중복 방지 테크닉
```java
// 방법 1: 절반까지만 순회
for (int i = 1; i < (x + 1) / 2; i++)

// 방법 2: 조건으로 필터링
if (target < arr[i])  // 작은 값만 찾기
```

---

## 🚀 다음에 시도해볼 것

1. **투 포인터로 다시 풀어보기**
   - 정렬 후 양쪽에서 좁혀가는 방식

2. **비슷한 문제**
   - 백준 1940: 주몽 (두 수의 합 변형)
   - 백준 2003: 수들의 합 2 (연속 부분합)
   - LeetCode 1: Two Sum

3. **확장 문제**
   - 세 수의 합 (3Sum)
   - K개 수의 합

---

## ✨ 총평

> **효율적인 카운팅 풀이입니다!**
> 
> 카운팅 배열을 활용해 O(n + x) 시간에 해결했습니다.
> `(x + 1) / 2`까지만 순회하는 중복 방지 로직이 깔끔합니다.
> 
> 다만 x가 매우 클 때 메모리 사용이 늘어날 수 있으니,
> 투 포인터 방식도 익혀두면 좋습니다!

---

*리뷰 일자: 2026-02-11*
