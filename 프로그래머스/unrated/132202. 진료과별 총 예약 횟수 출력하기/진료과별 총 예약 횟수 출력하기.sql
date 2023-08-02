-- 코드를 입력하세요 
SELECT mcdp_cd as 진료과코드, count(*) as 5월예약건수
from appointment
where YEAR(APNT_YMD) = 2022 and month(APNT_YMD) = 5
group by MCDP_CD
having count(*)
order by 5월예약건수, 진료과코드