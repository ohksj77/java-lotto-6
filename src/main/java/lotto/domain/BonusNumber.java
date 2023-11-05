package lotto.domain;

import lotto.constant.ErrorMessage;
import lotto.constant.WinningGrade;

import java.util.List;

public final class BonusNumber {

    private static final int MIN_BONUS_NUMBER = 1;
    private static final int MAX_BONUS_NUMBER = 45;
    private final Integer value;

    public BonusNumber(final Integer value) {
        validate(value);
        this.value = value;
    }

    private void validate(final Integer value) {
        if (MIN_BONUS_NUMBER > value || MAX_BONUS_NUMBER < value) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_RANGE.toValue());
        }
    }

    public WinningGrade checkSecondWinning(final List<Integer> numbers) {
        if (hasBonusNumber(numbers)) {
            return WinningGrade.SECOND_GRADE;
        }
        return WinningGrade.THIRD_GRADE;
    }

    private boolean hasBonusNumber(final List<Integer> numbers) {
        return numbers.contains(value);
    }
}
