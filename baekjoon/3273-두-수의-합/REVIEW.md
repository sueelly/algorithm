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
   - boolean 배열로 바꾸면 1/32 절약 가능

2. **x/2일 때 처리**
   - x가 짝수이고 x/2가 수열에 있으면?
   - 현재 코드는 `(x+1)/2`까지만 순회해서 x/2 케이스 제외됨
   - ⚠️ 이 경우 별도 처리 필요할 수 있음

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

## 🏆 대표 풀이 2: boolean 배열

```java
public int solve(int n, int[] arr, int x) {
    boolean[] exist = new boolean[x + 1];
    int count = 0;
    
    for (int i = 0; i < n; i++) {
        if (arr[i] <= x) {
            exist[arr[i]] = true;
        }
    }
    
    for (int i = 0; i < n; i++) {
        int target = x - arr[i];
        if (target > 0 && target < arr[i] && target <= x && exist[target]) {
            count++;
        }
    }
    return count;
}
```

### 특징
- 시간 복잡도 **O(n)**
- 공간 복잡도 **O(x)** (boolean이라 메모리 절약)
- `target < arr[i]` 조건으로 중복 방지

---

## 📊 비교

| 항목 | 내 코드 | 투 포인터 | boolean 배열 |
|------|---------|-----------|--------------|
| 시간 복잡도 | O(n + x) | O(n log n) | O(n) |
| 공간 복잡도 | O(x) int[] | O(1) | O(x) boolean[] |
| 메모리 | 8MB (x=2M) | 거의 없음 | 2MB (x=2M) |
| 구현 난이도 | ⭐⭐ | ⭐⭐⭐ | ⭐⭐ |

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
