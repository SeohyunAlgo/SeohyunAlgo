### 병합 정렬

- 분할 정복 알고리즘
- 언제나 절반씩 분할이 되기 때문에 항상 O(nlogn)
- 배열을 복사하기 때문에 추가적인 시간,메모리를 쓴다

![image](https://github.com/SeohyunAlgo/SeohyunAlgo/assets/75432228/4d94a81a-822e-43ce-8b89-d9fa2c711e2f)


### 퀵정렬

- 분할 정복 알고리즘
- 기준값 pivot 을 사용
- O(n*logn), 그룹의 개수가 비대칭적으로 쏠리면 O(n²)
- 숫자들이 거의 정렬되어 있거나 역순인 경우 효율이 좋지 않다

![image](https://github.com/SeohyunAlgo/SeohyunAlgo/assets/75432228/4f63104a-b135-4a8d-8aef-457379704f92)


### 기수정렬

- 주어진 수 들간의 비교를 하지 않고 버킷을 사용해 정렬하는  방법
- O(자릿수*n)
- 메모리가 많이 필요

![image](https://github.com/SeohyunAlgo/SeohyunAlgo/assets/75432228/a9db8fa2-37b8-484c-949b-80713c65a92f)


### 셸정렬

- 초기리스트가 "거의 정렬"되어 있을 경우 효율적
- gap = n / 2
- [Gap sequences](https://en.wikipedia.org/wiki/Shellsort#Gap_sequences)
- 정렬된 경우 O(n), 평균 O(n^1.3) ~ O(n^1.5), 최악의 경우 O(n^2)

![image](https://github.com/SeohyunAlgo/SeohyunAlgo/assets/75432228/484aa352-6d6c-478e-a57d-253c933ecc9a)
