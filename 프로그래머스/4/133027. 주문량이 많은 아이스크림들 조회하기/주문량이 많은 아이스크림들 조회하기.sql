SELECT july_flavor.flavor from 
first_half left join (select flavor, sum(total_order) as total_order from july
group by flavor) july_flavor 
on first_half.flavor = july_flavor.flavor
where first_half.flavor = july_flavor.flavor
order by (first_half.total_order + july_flavor.total_order) desc limit 3;