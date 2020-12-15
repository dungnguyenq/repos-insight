package com.githubtools.demo.service;

import com.githubtools.demo.entity.dto.TimePeriodReturnDTO;
import org.hibernate.mapping.Collection;
import org.springframework.stereotype.Service;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class MasterServiceImpl implements MasterService {

    @Override
    public List<TimePeriodReturnDTO> getWeeks(){
        LocalDate localDate = LocalDate.now();
        YearMonth ym = YearMonth.of( localDate.getYear() , localDate.getMonth().minus(3));
        LocalDate firstOfMonth = ym.atDay( localDate.getDayOfMonth() ) ;
        TemporalAdjuster ta = TemporalAdjusters.previousOrSame( DayOfWeek.SUNDAY ) ;
        LocalDate previousOrSameSunday = firstOfMonth.with( ta ) ;

        List<TimePeriodReturnDTO> weeks = new ArrayList<>();
        LocalDate startWeek = previousOrSameSunday ;
        do {
            LocalDate endWeek = startWeek.plusDays( 6 ) ;
            TimePeriodReturnDTO week = new TimePeriodReturnDTO(startWeek.toString(), endWeek.toString(), startWeek.toString() + " To "+ endWeek.toString());
            weeks.add(week);

            startWeek = startWeek.plusWeeks( 1 ) ;
        } while ( ! startWeek.isAfter( localDate ) ) ;

        Collections.reverse(weeks);
        return Collections.unmodifiableList(weeks);
    }

    @Override
    public List<TimePeriodReturnDTO> getMonths() {
        LocalDate localDate = LocalDate.now();
        YearMonth ym = YearMonth.of( localDate.getYear() , localDate.getMonth());

        List<TimePeriodReturnDTO> months = new ArrayList<>();
        YearMonth tempYm = YearMonth.of( localDate.getYear() , localDate.getMonth().minus(3));
        do {
            LocalDate startMonth = tempYm.atDay(1) ;
            LocalDate endMonth = tempYm.atEndOfMonth();
            TimePeriodReturnDTO month = new TimePeriodReturnDTO(startMonth.toString(), endMonth.toString(), tempYm.getMonth().toString());
            months.add(month);

            tempYm = tempYm.plusMonths(1);
        } while ( !tempYm.isAfter(ym) ) ;

        Collections.reverse(months);
        return Collections.unmodifiableList(months);
    }
}
