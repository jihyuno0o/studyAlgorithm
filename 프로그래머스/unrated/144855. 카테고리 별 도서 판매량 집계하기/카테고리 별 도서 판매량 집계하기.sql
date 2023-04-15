-- 코드를 입력하세요
SELECt b.category, sum(s.sales) as total_sales
from book_sales s left join book b on b.book_id = s.book_id
where year(s.sales_date) = '2022' and month(s.sales_date) = '01'
group by b.category
order by b.category;