-- 코드를 입력하세요
SELECT u.user_id, u.nickname, concat(city, ' ', street_address1, ' ', street_address2) as '전체주소',
        concat(substring(tlno, 1,3), '-', substring(tlno, 4,4), '-', substring(tlno, 8,4)) as '전화번호'
from used_goods_board b left join used_goods_user u on b.writer_id = u.user_id
group by u.user_id having count(*) >=3
order by u.user_id desc;