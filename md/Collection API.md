# Collection API

- 배열 대신 많이 사용
- 저장할 수 있는 데이터의 타입에 제한이 없다.
- 특정 타입만 저장하려고 제한하는 것도 가능하다.
- 저장할 수 있는 데이터의 갯수에 제한이 없다



### List

저장되는 데이터의 순서를 유지한다.

저장되는 데이터의 중복을 허용한다.

ArrayList, LinkedList, Vector(올드버전, 사용권장x)



### Set

저장되는 데이터의 순서를 유지하지 않는다.

저장되는 데이터의 중복을 허용하지 않는다.

해시값을 가지고 중복이 되는지 확인?

HashSet, LinkedHashSet(올드버전, 사용권장x)



### Map

데이터 이름과 데이터 값을 쌍으로 저장한다.

데이터 이름은 중복 저장이 불가능 하다.

Key-value 쌍으로 데이터를 저장

HashMap, Hashtable(올드버전, 사용권장x)



Hash 알고리즘은 빨리 검색하기 위해서 사용한다.



<img src="C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20191219093109491.png" alt="image-20191219093109491"  />





       System.out.println("=================Type1=================");
     
        Iterator<String> mapIter = hashMap.keySet().iterator();
     
        while(mapIter.hasNext()){
     
            String key = mapIter.next();
            String value = hashMap.get( key );
     
            System.out.println(key+" : "+value);
     
        }
     
        System.out.println("=================Type2=================");
     
        for(Map.Entry<String, String> elem : hashMap.entrySet()){
     
            String key = elem.getKey();
            String value = elem.getValue();
     
            System.out.println(key+" : "+value);
     
        }
     
        System.out.println("=================Type2=================");
     
        for(String key : hashMap.keySet()){
     
            String value = hashMap.get(key);
     
            System.out.println(key+" : "+value);
     
        }
        

## Collections 클래스 

* Collection API들을 도와주는 도우미 클래스
* 

