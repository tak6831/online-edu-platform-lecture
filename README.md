### Kafka 기능 추가

- kafka & zookeeper
  - https://github.com/wurstmeister/kafka-docker


- Producer
  - [Config 파일](https://github.com/radic2510/online-edu-platform-lecture/blob/main/src/main/java/com/example/onlineeduplatformlecture/config/KafkaProducerConfig.java)
  - [Service](https://github.com/radic2510/online-edu-platform-lecture/blob/main/src/main/java/com/example/onlineeduplatformlecture/service/impl/RatingServiceImpl.java#L63)
  ```java
  // 별점 등록 시 Rating 정보 JSON 형태로 kafka 토픽에 등록
  private void sendMessage(Rating rating) {
      log.info(String.format("#### -> Producing message -> %s", rating.toString()));
      this.ratingKafkaTemplate.send(TOPIC, rating);
  }
  ```

- Consumer
  - [Config 파일 링크](https://github.com/radic2510/online-edu-platform-lecture/blob/main/src/main/java/com/example/onlineeduplatformlecture/config/KafkaConsumerConfig.java)
  - [Service](https://github.com/radic2510/online-edu-platform-lecture/blob/main/src/main/java/com/example/onlineeduplatformlecture/service/impl/RatingServiceImpl.java#L69)
  ```java
  // 토픽 등록된 정보를 가져와서 해당 정보를 출력
  @KafkaListener(topics = TOPIC, groupId = "rating", containerFactory = "greetingKafkaListenerContainerFactory")
  public void consume(Rating rating) {
      System.out.printf("Consumed message : %s%n", rating.getRatingId());
  }
  ```

### Lecture

<details>
  <summary>
    <code>GET</code> 
    <code><b>/lecture</b></code> 
    <code>(강의 리스트 조회)</code>
  </summary>

##### Header

> | name   | Description      | Required |
  > |--------|------------------|-----------|
> | `Authorization` |   사용자 인증 수단, 액세스 토큰 값     | O |
##### Responses

> | name   |  type      | Description      | Required |
  > |--------|------------|----------------|---|
> | `elements` |  Integer[]  | 강의ID 목록     | O |

</details>

<details>
  <summary>
    <code>GET</code> 
    <code><b>/lectures/{lectureId}</b></code> 
    <code>(강의 열람)</code>
  </summary>

##### Header

> | name   | Description      | Required |
> |--------|------------------|-----------|
> | `Authorization` |   사용자 인증 수단, 액세스 토큰 값     | O |
##### Parameters

> | name   |  type      | Description      | Required |
> |--------|------------|----------------|---|
> | `lectureId` |  Integer  | 강의 ID     | O |

##### Responses

> | name   |  type      | Description      | Required |
> |--------|------------|----------------|---|
> | `title` |  String  | 강의명     | O |
> | `location` |  String  | 강의 장소     | O |

</details>

<details>
  <summary>
    <code>GET</code> 
    <code><b>/lectures/{lectureId}/contents</b></code> 
    <code>(콘텐츠 리스트 조회)</code>
  </summary>

##### Header

> | name   | Description      | Required |
> |--------|------------------|-----------|
> | `Authorization` |   사용자 인증 수단, 액세스 토큰 값     | O |
##### Responses

> | name   |  type      | Description      | Required |
> |--------|------------|----------------|---|
> | `elements` |  Integer[]  | 콘텐츠 ID 목록     | O |

</details>



<details>
  <summary>
    <code>GET</code> 
    <code><b>/lectures/{lectureId}/contents/{contentId}</b></code> 
    <code>(콘텐츠 열람)</code>
  </summary>

##### Header

> | name   | Description      | Required |
> |--------|------------------|-----------|
> | `Authorization` |   사용자 인증 수단, 액세스 토큰 값     | O |
##### Responses

> | name   |  type      | Description      | Required |
> |--------|------------|----------------|---|
> | `content` |  String  | 콘텐츠     | O |
> | `examYn` |  String  | 시험유무     |  |

</details>

<details>
  <summary>
    <code>GET</code> 
    <code><b>/lectures/{lectureId}/score</b></code> 
    <code>(성적 조회)</code>
  </summary>

##### Header

> | name   | Description      | Required |
> |--------|------------------|-----------|
> | `Authorization` |   사용자 인증 수단, 액세스 토큰 값     | O |
##### Responses

> | name   |  type      | Description      | Required |
> |--------|------------|----------------|---|
> | `score` |  String  | 성적     | O |
> | `comment` |  String  | 코멘트     |  |

</details>


<details>
  <summary>
    <code>GET</code> 
    <code><b>/lectures/{lectureId}/rating</b></code> 
    <code>(별점 리스트 조회)</code>
  </summary>

##### Header

> | name   | Description      | Required |
> |--------|------------------|-----------|
> | `Authorization` |   사용자 인증 수단, 액세스 토큰 값     | O |
##### Responses

> | name   |  type      | Description      | Required |
> |--------|------------|----------------|---|
> | `elements` |  Integer[]  | 별점 ID 목록    | O |
> | `average_rating` |  String  | 별점 평균     |  |

</details>


<details>
  <summary>
    <code>GET</code> 
    <code><b>/lectures/{lectureId}/rating/{ratingId}</b></code> 
    <code>(별점 조회)</code>
  </summary>

##### Header

> | name   | Description      | Required |
> |--------|------------------|-----------|
> | `Authorization` |   사용자 인증 수단, 액세스 토큰 값     | O |
##### Responses

> | name   |  type      | Description      | Required |
> |--------|------------|----------------|---|
> | `rating` |  Float  | 별점     | O |
> | `comment` |  String  | 코멘트     |  |

</details>

<br>

<details>
  <summary>
    <code>POST</code> 
    <code><b>/lectures</b></code> 
    <code>(강의 개설)</code>
  </summary>

##### Header

> | name | Description      | Required |
------|--------|------------------|-----------|
> | `Authorization`  |   사용자 인증 수단, 액세스 토큰 값     | O |
##### Parameters

> | name |  type      | Description      | Required |
------|--------|------------|----------------|---|
> | `title`  |  String  | 강의명     | O |
> | `location`  |  String  | 강의장소     |  |

##### Responses

> | name           |  type      | Description      | Required |
----------------|--------|------------|----------------|---|
> | `lectureId` |  Integer  | 강의 ID     | O |

</details>


<details>
  <summary>
    <code>POST</code> 
    <code><b>/lectures/{lectureId}/enrolment</b></code> 
    <code>(수강 신청)</code>
  </summary>

##### Header

> | name   | Description      | Required |
> |--------|------------------|-----------|
> | `Authorization` |   사용자 인증 수단, 액세스 토큰 값     | O |
##### Parameters

> | name   |  type      | Description      | Required |
> |--------|------------|----------------|---|
> | `userId` |  Integer  | 회원 ID     | O |

##### Responses

> | name   |  type      | Description      | Required |
> |--------|------------|----------------|---|
> | `enrolmentId` |  Integer  | 수강신청 ID     | O |

</details>

<details>
  <summary>
    <code>POST</code> 
    <code><b>/lectures/{lectureId}/matching</b></code> 
    <code>(강사 매칭)</code>
  </summary>

##### Header

> | name   | Description      | Required |
> |--------|------------------|-----------|
> | `Authorization` |   사용자 인증 수단, 액세스 토큰 값     | O |
##### Parameters

> | name   |  type      | Description      | Required |
> |--------|------------|----------------|---|
> | `lectureId` |  Integer  | 강의 ID     | O |
> | `userId` |  Integer  | 강사 회원 ID     | O |

##### Responses

> | name   |  type      | Description      | Required |
> |--------|------------|----------------|---|
> | `matchingId` |  Integer  | 매칭 ID     | O |

</details>

<details>
  <summary>
    <code>POST</code> 
    <code><b>/lectures/{lectureId}/contents</b></code> 
    <code>(컨텐츠 등록)</code>
  </summary>

##### Header

> | name   | Description      | Required |
> |--------|------------------|-----------|
> | `Authorization` |   사용자 인증 수단, 액세스 토큰 값     | O |
##### Parameters

> | name   |  type      | Description      | Required |
> |--------|------------|----------------|---|
> | `content` |  String  | 컨텐츠     | O |
> | `examYn` |  String  | 시험유무     |  |

##### Responses

> | name   |  type      | Description      | Required |
> |--------|------------|----------------|---|
> | `contentId` |  Integer  | 콘텐츠 ID     | O |

</details>

<details>
  <summary>
    <code>POST</code> 
    <code><b>/lectures/{lectureId}/score/{userId}</b></code> 
    <code>(성적 입력)</code>
  </summary>

##### Header

> | name   | Description      | Required |
> |--------|------------------|-----------|
> | `Authorization` |   사용자 인증 수단, 액세스 토큰 값     | O |
##### Parameters

> | name   |  type      | Description      | Required |
> |--------|------------|----------------|---|
> | `score` |  String  | 성적     | O |
> | `comment` |  String  | 코멘트     |  |

##### Responses

> | name   |  type      | Description      | Required |
> |--------|------------|----------------|---|
> | `scoreId` |  Integer  | 성적 ID     | O |

</details>

<details>
  <summary>
    <code>POST</code> 
    <code><b>/lectures/{lectureId}/rating</b></code> 
    <code>(별점 입력)</code>
  </summary>

##### Header

> | name   | Description      | Required |
> |--------|------------------|-----------|
> | `Authorization` |   사용자 인증 수단, 액세스 토큰 값     | O |
##### Parameters

> | name   |  type      | Description      | Required |
> |--------|------------|----------------|---|
> | `rating` |  Float  | 별점     | O |
> | `comment` |  String  | 코멘트     |  |

##### Responses

> | name   |  type      | Description      | Required |
> |--------|------------|----------------|---|
> | `ratingId` |  Integer  | 별점 ID     | O |

</details>

<br>

<details>
  <summary>
    <code>PATCH</code> 
    <code><b>/lectures/{lectureId}</b></code> 
    <code>(강의 노출 상태 변경)</code>
  </summary>

##### Header

> | name   | Description      | Required |
> |--------|------------------|-----------|
> | `Authorization` |   사용자 인증 수단, 액세스 토큰 값     | O |
##### Parameters

> | name   |  type      | Description      | Required |
> |--------|------------|----------------|---|
> | `lectureId` |  Integer  | 강의 ID     | O |

##### Responses

> | name   |  type      | Description      | Required |
> |--------|------------|----------------|---|
> | `exposedYn` |  String  | 강의 노출 유무  | O |

</details>
