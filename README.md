# 유수민

# 📌설계 구조 
본 구조는  하나의 모듈에 모든 기능이 다 이루어진 것이 아닌한 멀티모듈로 구현되어있습니다. 
이전 경험에 하나의 모듈에 모든 api를 이루도록 구성하다보니 처음에 만들기는 편하지만, 점점 의존성과 결합도가 강해지는 것을 느꼈습니다. 따라서 멀티모듈을 통해 의존성과 결합도를 낮추고 좀 더 확장성 있는 구조로 만들고 싶었습니다.

## 
<aside>
💡 구조도
  
- server : main 모듈의 역할을 합니다.
  - RealEstateCommunityApplication
  - support : CommonHandlerException
- common : 모든 모듈에서 공통적으로 사용할 요소들이 있습니다.
  - error : DomainException, ResponseCode
  - response : CommonApiResponse
  - AccountType
- user-api : 현재 domain에 user 엔티티만 만들어져 있습니다. 구현은 안되어 있지만 로그인, 로그아웃과 같은 로직이 들어갈 모듈입니다.
- writing-api: 글에 관한 내용이 있는 모듈입니다.
  - writing-presentation
    - postController, heartController
    - request : PostCreateRequest,PostDeleteRequest,PostModifyRequest,HeartCreateRequest
    - exception : WritingExceptionHandler
  - writing-application
    - config : HeartRepositoryConfig,PostRepositoryConfig,QueryModuleConfiguration,WritingApplicationServiceConfiguration
    - reader : MyBatisUserReader
    - repository
      - PostRepositoryAdaptor, HeartRepositoryAdaptor
      - jpa : PostJpaRepository,HeartJpaRepository
  - writing-domain
    - Post,Heart,ReadUserModel,UserReader
    - DTO : PageDTO,PageResultDTO,UserDTO,WritingDTO
    - exception : AlreadyDeletedPostException,AlreadyHeartException,UnAuthorizedUserException
    - repository : HeartRepository,PostRepository
    - writing-application
    - PostCreateProcessor, PostDeleteProcessor, PostHeartModifyProcessor, PostingListFetchProcessor, PostModifyProcessor, HeartCreateProcessor, MyHeartFetchProcessor, UserCheckProcessor
 </aside>
 
# 📌사용한 기술들
* Java 8 , Spring boot 2.6.4
* MariaDB
* JPA, Mybatis

# 📌구현했을때 고려한 것들
 * DB : RDB 중 mysql과 mariaDB 중 고민을 했습니다. mariadb는 MySQL기반으로 만들어졌기 때문에 쿼리를 비롯한 전반적인 사용법은 MySQL과 유사하면서도 더 개선된 요소가 많기 때문에 mariaDB를 이용하기로 결정하였습니다.
 * controller에서 processor로 request에 대한 정보를 전달할때 따로 command를 통해 전달하게하였습니다. 
 * processor 이름에 모듈 이름인 writing을 쓸지 고민을 하였습니다. writing과 posting은 모두 명사로 글이라는 의미가 담겨있는데요. writing의 경우 작성하다는 의미도 내포하고 있어 삭제,수정의 processor에서는 writing이라는 이름이 들어가면 적절하지 않다고 생각하여 processor에는 posting이라는 이름을 이용했습니다. 
* 글 작성, 삭제, 수정 모두 response를 반영된 post객체를 반환하도록 하였습니다. 
예시 )
![image](https://user-images.githubusercontent.com/68679529/216613121-a850db9d-3e64-4b4e-9aa3-d8e69c64dacb.png)
* 글 작성할 때, post객체에 일부 user정보를 저장해야해서 user의 정보를 조회해야햇습니다. 단순 조회기능에 jpa를 이용해야 할지 mybatis를 이용해야할지 고민하다, cqrs기법을 활용하기로 결정하고 mybatis를 이용해 user를 조회하도록 하였습니다.
* 글 삭제 기능의 경우, delete쿼리를 날려야 할지, 마크(boolean)를 두고 나중에 한꺼번에 삭제를 해야할지 고민했습니다. 바로 삭제를 했을 경우의 위험성도 있고 추후 삭제한 글에 대한 활용도가 있을 수 있기때문에 마크를 이용하여 삭제하였다는 표시만 하도록 하기록 결정했습니다. 
* 좋아요 기능의 두가지 기능을 구현하였습니다. 자신의 좋아요 표시를 한 글들 확인하기, 좋아요 표시하기입니다. 좋아요를 표시하면 바로 해당 글의 좋아요수에 반영되지 않고 대략 5초후에 반영이 되도록 하였습니다. 즉, 표시할 당시에는 데이터 정합성이 맞지 않지만 후에 데이터를 맞추는 방법을 사용하였습니다. 좋아요 표시하는 기능은 데이터 정합성보다는 모든 사람이 동시에 기능을 이용할 수 있는 것이 더 중요하다고 생각했습니다. 한 예로 인스타그램의 경우, 좋아요를 눌렀을때, 해당 게시물의 총 좋아요 수는 그대로이나 하트 모양의 표시는 반영되는 것을 확인 할 수 있습니다. 즉, 좋아요 표시를 한 클라이언트에게 좋아요 기능이 반영이 되었다는 것만 해주고 나중에 글의 좋아요 수에 반영하는 것을 볼 수 있습니다. 만약 데이터 정합성을 중요시 여겨 동시 클라이언트가 좋아요 기능을 이용하지 못한다면 클라이언트 입장으로 볼때는 제대로 기능이 작동하지 않는다고 생각할 수 있기 때문에 데이터정합성보다는 동시성을 더 중요하게 여겨야한다고 생각했습니다. 
*  글 목록 기능의 경우 삭제표시가 되지 않은 글들만 모아서 front 쪽에서 페이지기능을 이용할 수 있도록 구현하였습니다. 
![image](https://user-images.githubusercontent.com/68679529/216620545-e84192a0-e9b7-4d70-8ce6-ff2fe5e049f9.png)

# 📌테스트 url
* 글 작성하기 : post - http://localhost:8080/posting/createPost , request data - title(String형태), contents(String형태)
* 글 수정하기 : post - http://localhost:8080/posting/modifyPost , request data - title(String형태), postId(Long형태), contents(String형태)
* 글 삭제하기 : post - http://localhost:8080/posting/deletePost , request data - postId(Long형태)
* 좋아요 주기 : post - http://localhost:8080/heart/giveHeart , request data - postId(Long형태)
* 내좋아요 보기 : get - http://localhost:8080/heart/getMyHearts
* 글목록가져오기 : get - http://localhost:8080/posting/getWritingList

user테이블에 3명의 user가 존재하도록 했습니다. Authentication 에 Lessee 562 , Realtor 47, Lessor 21 를 넣어주고 테스트 하시면 됩니다.
