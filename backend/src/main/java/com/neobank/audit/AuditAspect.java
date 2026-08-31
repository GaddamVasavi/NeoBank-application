package com.neobank.audit;

import com.neobank.security.SecurityUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Aspect
@Component
@RequiredArgsConstructor
public class AuditAspect {

    private final AuditService auditService;

    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
    public void restControllerPointcut() {}

    @AfterReturning(pointcut = "execution(* com.neobank.auth.AuthService.login(..))", returning = "result")
    public void auditLoginSuccess(JoinPoint joinPoint, Object result) {
        UUID userId = SecurityUtils.getCurrentUserId();
        String username = SecurityUtils.getCurrentUsername();
        if (userId != null) {
            auditService.log(userId, username, AuditAction.LOGIN, "User", userId.toString(), "SUCCESS", "User login via AOP", null, null, AuditSeverity.INFO);
        }
    }
}
