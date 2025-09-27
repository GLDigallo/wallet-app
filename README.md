**Introducción

Este proyecto tiene como objetivo principal implementar una Wallet digital mediante una arquitectura de microservicios, lo que permite escalabilidad, modularidad y un desarrollo ágil de nuevas funcionalidades.

La versión V1 corresponde a la etapa inicial del proyecto, en la que se ha implementado el AuthService, responsable de la autenticación y autorización de usuarios. Esta versión sienta las bases de la arquitectura y prepara el terreno para los próximos microservicios.


**Arquitectura V1

La versión inicial incluye:

AuthService:

Gestión de usuarios (registro, login, roles).

Seguridad básica con roles y control de acceso.

Integración con JWT para autenticación.

Nota: Todos los microservicios futuros seguirán el mismo patrón de diseño, garantizando consistencia y escalabilidad.


**Evolución prevista

A medida que el proyecto crezca, se incorporarán nuevos microservicios y capas de seguridad:

WalletService:

Gestión de balances.

Transacciones internas y externas.

Historial de operaciones.

TransactionService:

Validación y procesamiento de pagos.

Notificaciones y alertas de transacciones.

SecurityService (opcional futuro):

Monitoreo de accesos y auditorías.

Prevención de fraudes y seguridad avanzada.

Otros microservicios:

Funcionalidades complementarias según necesidades del proyecto (ej: promociones, reportes, integraciones externas).



**Beneficios de la arquitectura

Escalabilidad: Cada microservicio puede crecer de manera independiente.

Mantenibilidad: Código modular, más fácil de actualizar y probar.

Seguridad: Cada servicio puede implementar sus propias reglas de seguridad y autenticación.

**Estado actual (V1)

AuthService: ✅ Implementado y funcional.

WalletService: ⏳ En planificación.

TransactionService: ⏳ Futuro desarrollo.

SecurityService: ⏳ Futuro desarrollo.