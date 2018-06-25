
/***********************************************************************************************************
 * Module Name - PlanoAccounting
 * Version Control Block
 * 
 * Date			Version	   Author			Reviewer			Change Description
 * -----------  ---------  --------------	----------------	-------------------------------------------
 * Jun 24, 2018  1.0		   Singh, Bed		XXXXXXXX			Created.
 * -----------  ---------  --------------	----------------	-------------------------------------------
 * 
 ***********************************************************************************************************/

package com.plano.accounting.aop;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import com.plano.accounting.constants.CommonConstants;

/***********************************************************************************************************
 * Java File - ExecutionTimeLogAspect.java
 * Author - Bed Singh
 * Date   - Jun 24, 2018
 * Description - 
 ***********************************************************************************************************/

@Aspect
@Component
public class ExecutionTimeLogAspect implements CommonConstants {
	
	private static Logger logger = LogManager.getLogger(ExecutionTimeLogAspect.class);
	
	@Pointcut(LOG_ANNOTATION_EXPRESSION)
	public void logPointcut() {} 
	
	@Pointcut(RESOURCE_EXPRESSION)
	public void resourceLogPointcut() {} 
	
	@Pointcut(SERVICE_EXPRESSION)
	public void serviceLogPointcut() {} 

	@Pointcut(AOP_EXPRESSION)
	public void aopLogPointcut() {} 
	
	
	@Around("logPointcut() && (resourceLogPointcut() || serviceLogPointcut() ) ")
	public Object logForResource(final ProceedingJoinPoint jointPoint) throws Throwable
	{
		final Optional<ProceedingJoinPoint> jointPointOptional = Optional.ofNullable(jointPoint);
		final String className = jointPointOptional.map(ProceedingJoinPoint :: getSignature)
		.map(Signature :: getDeclaringType)
		.map(Class :: getSimpleName)
		.orElse(null);
		
		final String methodName = jointPointOptional.map(ProceedingJoinPoint :: getSignature)
				.map(Signature :: getName)
				.orElse(null);
		
		final MethodSignature mthdSignature = (MethodSignature)jointPointOptional.map(ProceedingJoinPoint :: getSignature).get();
		final String [] names = mthdSignature.getParameterNames();
		IntStream intStream = IntStream.range(0, names.length);
		final Object [] values = jointPointOptional.map(ProceedingJoinPoint :: getArgs).get();
		final String paramValues = intStream.mapToObj(index -> names[index]+"="+values[index]).collect(Collectors.joining(" "));
		intStream.close();
		
		//logger.info(CLASS_NAME+className+ METHOD+methodName+START+ "REQ_PARAMS: { "+String.join(", ", names)+ " }");
		logger.info(CLASS_NAME+className+ METHOD+methodName+START+ "REQ_PARAMS: { "+paramValues+ " }");
		
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		Object objectValue = jointPoint.proceed();
		stopWatch.stop();
		
		logger.info(CLASS_NAME+className+ METHOD+methodName+END+ TIME+stopWatch.getTotalTimeMillis()+MILLIS);
		return objectValue;
	}
	
}
