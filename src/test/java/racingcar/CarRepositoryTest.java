package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.CarRepository;
import racingcar.domain.car.Name;
import racingcar.domain.car.Position;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarRepositoryTest {

    @DisplayName("우승자 결과 테스트 한 명")
    @Test
    void singleWinnerResult() {
        final Car winner = new Car(new Name("pobi"), new Position(4));
        final Car loser = new Car(new Name("crong"), new Position(2));
        final CarRepository carRepository
                = new CarRepository(Arrays.asList(winner, loser));
        final List<Car> winners = carRepository.winners();

        Assertions.assertThat(winners.size()).isEqualTo(1);
        Assertions.assertThat(winners.get(0)).isEqualTo(winner);
    }

    @DisplayName("우승자 결과 테스트 여러명")
    @Test
    void multiWinnerResult() {
        final Car winner1 = new Car(new Name("pobi"), new Position(3));
        final Car winner2 = new Car(new Name("poci"), new Position(3));
        final Car winner3 = new Car(new Name("podi"), new Position(3));
        final Car loser = new Car(new Name("crong"), new Position(1));
        final CarRepository carRepository
                = new CarRepository(Arrays.asList(winner1, winner2, winner3, loser));
        final List<Car> expectedWinners = Arrays.asList(winner1, winner2, winner3);

        final List<Car> actualWinners = carRepository.winners();

        Assertions.assertThat(actualWinners.size()).isEqualTo(3);
        Assertions.assertThat(actualWinners.containsAll(expectedWinners)).isTrue();
    }
}
