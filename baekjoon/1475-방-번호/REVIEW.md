# 1475번: 방 번호 - 코드 리뷰

## 📝 내 코드

```java
public int solve(int n) {
    int[] numberCounts = new int[9];
    int max = 0;

    while (n > 0) {
        if (n % 10 == 9) numberCounts[6]++;
        else numberCounts[n % 10]++;
        n /= 10;
    }
    numberCounts[6] = numberCounts[6] / 2 + (numberCounts[6] & 1);
    for (int i = 0; i < 9; i++) {
        if (numberCounts[i] > max) max = numberCounts[i];
    }
    return max;
}
```

## ✅ 분석

### 시간 복잡도
- **O(log₁₀ n)**: 자릿수만큼 반복

### 공간 복잡도
- **O(1)**: 고정 크기 배열 (9개)

### 장점

1. **효율적인 메모리 사용**
   - `int[9]` 배열로 6과 9를 통합 관리
   - 인덱스 9가 필요 없어 배열 크기 최소화

2. **비트 연산 활용**
   - `/ 2 + (& 1)` → 올림 나눗셈 (ceil)
   - `(count + 1) / 2`와 동일한 결과

3. **깔끔한 로직**
   - 9를 만나면 6으로 카운트
   - 마지막에 한 번만 올림 처리

---

## 🏆 대표 풀이 1: 배열 크기 10 사용

```java
public int solve(int n) {
    int[] count = new int[10];
    
    while (n > 0) {
        count[n % 10]++;
        n /= 10;
    }
    
    // 6과 9 합쳐서 처리
    int sixNine = (count[6] + count[9] + 1) / 2;
    count[6] = sixNine;
    count[9] = 0;
    
    int max = 0;
    for (int i = 0; i < 10; i++) {
        max = Math.max(max, count[i]);
    }
    return max;
}
```

### 특징
- 직관적인 배열 크기 (0~9)
- 6과 9를 나중에 합산
- `(count[6] + count[9] + 1) / 2`로 올림

---

## 🏆 대표 풀이 2: String 변환

```java
public int solve(int n) {
    int[] count = new int[10];
    String s = String.valueOf(n);
    
    for (char c : s.toCharArray()) {
        count[c - '0']++;
    }
    
    count[6] = (count[6] + count[9] + 1) / 2;
    count[9] = 0;
    
    int max = 0;
    for (int c : count) {
        max = Math.max(max, c);
    }
    return max;
}
```

### 특징
- 문자열로 변환하여 처리
- for-each로 간결한 코드
- 약간의 오버헤드 (String 생성)

---

## 📊 비교

| 항목 | 내 코드 | 대표 풀이 1 | 대표 풀이 2 |
|------|---------|-------------|-------------|
| 배열 크기 | 9 | 10 | 10 |
| 6/9 처리 | 즉시 통합 | 나중에 합산 | 나중에 합산 |
| 올림 연산 | `/ 2 + (& 1)` | `(+1) / 2` | `(+1) / 2` |
| 가독성 | ⭐⭐⭐ | ⭐⭐⭐⭐ | ⭐⭐⭐⭐ |
| 성능 | ⭐⭐⭐⭐⭐ | ⭐⭐⭐⭐ | ⭐⭐⭐ |

---

## 💡 학습 포인트

### 1. 올림 나눗셈 테크닉
```java
// 방법 1: 비트 연산
int ceil = count / 2 + (count & 1);

// 방법 2: 덧셈 후 나눗셈 (더 직관적)
int ceil = (count + 1) / 2;

// 방법 3: Math.ceil (캐스팅 필요)
int ceil = (int) Math.ceil(count / 2.0);
```

### 2. 6과 9 통합 전략
- **즉시 통합**: 9를 6으로 카운트 (메모리 절약)
- **나중에 합산**: 각각 카운트 후 합침 (가독성 좋음)

### 3. 최대값 찾기
```java
// 방법 1: 직접 비교
if (count[i] > max) max = count[i];

// 방법 2: Math.max
max = Math.max(max, count[i]);

// 방법 3: Stream (Java 8+)
int max = Arrays.stream(count).max().getAsInt();
```

---

## 🚀 다음에 시도해볼 것

1. **Stream API 활용**
   - `IntStream`으로 더 함수형으로 작성해보기

2. **비슷한 문제**
   - 백준 2577: 숫자의 개수
   - 백준 10808: 알파벳 개수

3. **변형 문제**
   - 6과 9 외에 다른 숫자도 뒤집을 수 있다면?
   - 세트마다 각 숫자가 k개씩 있다면?

---

## ✨ 총평

> **잘 작성된 코드입니다!** 
> 
> 비트 연산을 활용한 올림 처리와 배열 크기 최적화가 인상적입니다.
> 가독성을 조금 더 높이고 싶다면 `(count + 1) / 2` 방식을 사용해도 좋습니다.
