//package abductionapi.exception;
//
//
//public interface IException {
///**
// * Ošetrenie vzniknutej exception - ak to už je {@link MultiObservationException} tak vrátime tú.
// * Ak to je HttpClientErrorException (400) tak vytvoríme tiež 400ku s priloženou pôvodnou chybou.
// * Ak to je iná chyba tak vznikne nová {@link MultiObservationException} s daným statusom a správou
// * @param exceptionType status ak ide o novú {@link MultiObservationException}
// * @param message správa ak ide o novú {@link MultiObservationException}
// * @param ex ošetrovaná chyba
// * @return Nová alebo pôvodná {@link MultiObservationException}
// */
//public default CommonException toException(ExceptionType exceptionType, String message, Exception ex) {
//
//	if (ex.getClass().equals(MultiObservationException.class)) {
//		return (MultiObservationException) ex;
//	}if (ex.getClass().equals(AxiomObservationException.class)) {
//		return (AxiomObservationException) ex;
//	}
//
//	return new CommonException(exceptionType, message, ex);
//}
//
////	public default AxiomObservationException toException(ExceptionType exceptionType, String message, Exception ex) {
////
////		if (ex.getClass().equals(AxiomObservationException.class)) {
////			return (AxiomObservationException) ex;
////		}
////
////		return new AxiomObservationException(exceptionType, message, ex);
////	}
////	/**
////	 * Ošetrenie vzniknutej exception - ak to už je {@link CommonException} tak vrátime tú.
////	 * Ak to je HttpClientErrorException (400) tak vytvoríme tiež 400ku s priloženou pôvodnou chybou.
////	 * Ak to je iná chyba tak vznikne nová {@link CommonException} so statusom {@link HttpStatus#INTERNAL_SERVER_ERROR}
////	 * @param message správa ak ide o novú {@link CommonException}
////	 * @param ex ošetrovaná chyba
////	 * @return Nová alebo pôvodná {@link CommonException}
////	 */
////	public default AxiomObservationException toException( String message, Exception ex) {
////		return toException(ExceptionType.OBSERVATION_EXCEPTIO, message, ex);
////	}
//}
