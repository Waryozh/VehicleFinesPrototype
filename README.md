# VehicleFinesPrototype
Тестовое задание для Payment Systems:

https://github.com/paysystems/Interview.Android

При старте приложения запускается StartingActivity, отображающая
сообщение о загрузке и ProgressBar.
Activity получает из SharedPreferences информацию о том,
на какой экран следует перейти.
Чтобы данную Activity можно было заметить для проверки,
переход на следующий экран переходит с задержкой в одну секунду.
После запуска следующей Activity StartingActivity завершает работу.

- Если уже была открыта OverviewActivity, происходит переход на неё.
- Если OverviewActivity ещё ни разу не была открыта, но была открыта
  WalkthroughActivity, происходит переход на неё.
- В противном случае запускается WizardActivity.

Таким образом, при первом запуске приложения StartingActivity запустит
WizardActivity, содержащую 4 фрагмента:

1. Приветственный фрагмент — позволяет перейти только на следующий фрагмент
2. Фрагмент ввода регистрационного номера ТС
3. Фрагмент ввода номера свидетельства о регистрации ТС
4. Фрагмент ввода номера водительского удостоверения

Поля ввода номеров документов поддерживают валидацию при вводе;
в случае неуспешной валидации отображается сообщение о некорректно введённом номере.
При пустом или некорректном номере переход на следующий фрагмент
по кнопке Далее невозможен.

При нажатии на кнопку Пропустить отображается диалог, позволяющий
подтвердить или отменить решение:

- При пропуске ввода регистрационного номера или номера свидетельства
  происходит переход на фрагмент ввода номера ВУ.
- С фрагмента ввода номера ВУ переход происходит на WalkthroughActivity.
  WizardActivity при этом завершает работу.

WalkthroughActivity содержит 6 фрагментов под управлением ViewPager2,
между которыми можно перемещаться с помощью свайпа экрана влево или вправо.
В нижней части экрана отображается графический счётчик из точек,
показывающий номер текущего фрагмента, а также кнопка для перехода на следующий фрагмент.
При показе последнего фрагмента эти элементы заменяются кнопкой для
перехода на OverviewActivity.

OverviewActivity отображает введённую в WizardActivity информацию.
Для пропущенных данных отображается предупреждение.
